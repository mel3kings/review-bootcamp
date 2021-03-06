#!/usr/bin/env python3

import argparse
import csv
import datetime
import getpass
import itertools
import lxml.html
import os
import pickle
import requests
import subprocess
import sys
import tempfile
import time


VERSION = 3

CACHE_DIR = os.environ.get("XDG_CACHE_HOME", os.path.expanduser("~/.cache/opal-card-tool"))
PICKLE_FILE = os.path.join(CACHE_DIR, "pickle")

USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64; rv:59.0) Gecko/20100101 Firefox/59.0"
OPAL_BASE = "https://www.opal.com.au"
LOGIN_URL = OPAL_BASE + "/login/registeredUserUsernameAndPasswordLogin"
CARD_DETAILS_URL = OPAL_BASE + "/registered/getJsonCardDetailsArray"
TRANSACTION_LIST_URL = OPAL_BASE + "/registered/opal-card-transactions/opal-card-activities-list?AMonth=-1&AYear=-1&cardIndex=%d&pageIndex=%d"



def stringify(el):
    return " ".join(t.strip() for t in el.itertext()).strip()

def get_first(l):
    for x in l:
        return x

def is_weekday(d):
    return d.isoweekday() <= 5

def n_days_ago(days):
    d = datetime.datetime.now() - datetime.timedelta(days=days)
    d = d.replace(hour=0, minute=0, second=0, microsecond=0)
    return d


class FatalError(Exception):
    pass

class Transaction(object):
    pass

class Card(object):
    def __init__(self):
        self.transaction_list = []

    def get_max_transaction(self):
        if self.transaction_list:
            return self.transaction_list[0].number
        else:
            return -1

    def add_transactions(self, l):
        self.transaction_list = l + self.transaction_list

class Opal(object):
    def __init__(self, username, password):
        self.version = VERSION
        self.username = username
        self.password = password
        self.cards = []

        self.init()

    def init(self):
        self.session = requests.Session()
        self.session.headers["User-Agent"] = USER_AGENT

    def login(self):
        print("Attempting login ", end="", flush=True)
        for i in range(10):
            print(".", end="", flush=True)
            self.login_once()
            if self.check_login():
                print(" ok")
                return

            time.sleep(1)

    def login_once(self):
        r = self.session.post(LOGIN_URL, {
            "h_username": self.username,
            "h_password": self.password,
        })
        if not r.ok:
            raise Exception("Failed to login, error code: %d" % r.status_code)

        json = r.json()
        if json["errorMessage"]:
            raise Exception("Failed to login: %s" % json["errorMessage"])

    def check_login(self):
        r = self.session.get(CARD_DETAILS_URL)
        try:
            r.json()
            return True
        except:
            return False

    def load(self):
        self.load_cards()
        for card in self.cards:
            self.load_transactions(card)

    def resolve_card_number(self, card_number):
        if int(card_number) < len(self.cards):
            return self.cards[int(card_number)].number
        else:
            return card_number

    def get_transaction_list_for_card(self, card_number):
        for card in self.cards:
            if card.number == card_number:
                return card.transaction_list

        return []

    def load_cards(self):
        r = self.session.get(CARD_DETAILS_URL)
        if not r.ok:
            raise Exception("Failed to login, error code: %d" % r.status_code)

        for index, card_json in enumerate(r.json()):
            card_number = card_json["cardNumber"]

            for card in self.cards:
                if card.number == card_number:
                    break
            else:
                card = Card()
                self.cards.append(card)

            card.number = card_number
            card.name = card_json["cardNickName"]
            card.index = index

    def load_transactions(self, card):
        print("Loading transactions for", card.number, "", end="", flush=True)
        max_transaction = card.get_max_transaction()
        transaction_list = []

        for page in itertools.count(1):
            print(".", end="", flush=True)
            transaction_page = self.fetch_transaction_page(card.index, page)
            continue_paging = False

            for transaction in transaction_page:
                if transaction.number <= max_transaction:
                    continue_paging = False
                    break

                transaction_list.append(transaction)
                continue_paging = True

            if not continue_paging:
                break

        print(" done")
        card.add_transactions(transaction_list)

    def parse_transaction(self, cells):
        t = Transaction()
        t.number = int(stringify(cells["transaction number"]))
        t.timestamp = datetime.datetime.strptime(stringify(cells["date/time"]), "%a %d/%m/%Y %H:%M")
        t.mode = get_first(cells["mode"].xpath("img/@alt"))
        t.details = stringify(cells["details"])
        t.journey_number = stringify(cells["journey number"])
        t.fare_applied = stringify(cells["fare applied"])
        t.fare = stringify(cells["fare"])
        t.fare_discount = stringify(cells["discount"])
        t.amount = stringify(cells["amount"])
        return t

    def fetch_transaction_page(self, card, page):
        url = TRANSACTION_LIST_URL % (card, page)
        r = self.session.get(url)
        if not r.ok:
            raise Exception("Failed to fetch transactions, error code: %d" % r.status_code)

        doc = lxml.html.fromstring(r.text)
        headers = [stringify(th).lower() for th in doc.xpath("//table/thead//th")]

        if not headers:
            return []

        for tr in doc.xpath("//table/tbody/tr"):
            try:
                yield self.parse_transaction(dict(zip(headers, tr.getchildren())))
            except Exception:
                print("Failed to parse:", headers, lxml.html.tostring(tr), file=sys.stderr)
                raise


class CommuterGraph(object):
    class gnuplot_dialect(csv.excel):
        delimiter = " "

    def __init__(self):
        self.data_am_csv, self.data_am_file = self.new_csv()
        self.data_pm_csv, self.data_pm_file = self.new_csv()
        self.plot_file = self.new_tempfile()
        self.files = [self.data_am_file, self.data_pm_file, self.plot_file]

        self.xrange_start = None
        self.xrange_end = None

    def is_plottable(self):
        return self.xrange_start is not None and self.xrange_end is not None

    def graph(self, transaction_list):
        try:
            self.write_points(transaction_list)
            if not self.is_plottable():
                print("No transactions!", file=sys.stderr)
                return
            self.write_plot_command()
            self.flush_files()
            self.run_gnuplot()
        finally:
            self.cleanup()

    def new_tempfile(self):
        return tempfile.NamedTemporaryFile(
            mode="w",
            encoding="utf-8",
            prefix="opal-card-tool-",
            delete=True,
        )

    def new_csv(self):
        f = self.new_tempfile()
        out = csv.writer(f, dialect=self.gnuplot_dialect)
        return out, f

    def update_xrange(self, ts):
        if self.xrange_start is None or ts < self.xrange_start:
            self.xrange_start = ts
        if self.xrange_end is None or ts > self.xrange_end:
            self.xrange_end = ts

    def generate_point(self, transaction):
        ts = transaction.timestamp
        x_date = ts.strftime("%Y-%m-%dT00:00:00")
        y_time = ts.strftime("2000-01-01T%H:%M:00")
        y_label = ts.strftime("%H:%M")
        return [x_date, y_time, y_label]

    def write_point(self, ts, point):
        if ts.time() < datetime.time(12):
            out_csv = self.data_am_csv
        else:
            out_csv = self.data_pm_csv

        out_csv.writerow(point)

    def write_points(self, transaction_list):
        for transaction in transaction_list:
            if not self.is_commuter_transaction(transaction):
                continue

            self.update_xrange(transaction.timestamp)
            point = self.generate_point(transaction)
            self.write_point(transaction.timestamp, point)

    def is_commuter_transaction(self, transaction):
        if not is_weekday(transaction.timestamp):
            return False
        if transaction.details.startswith("Auto top up"):
            return False
        return True

    def write_plot_command(self):
        d = {
            "data_am_filename": self.data_am_file.name,
            "data_pm_filename": self.data_pm_file.name,
            "xrange_start": self.xrange_start - datetime.timedelta(hours=24),
            "xrange_end": self.xrange_end + datetime.timedelta(hours=24),
        }
        self.plot_file.write(R"""
set timefmt '%Y-%m-%dT%H:%M:%S'

set xlabel 'Date'
set xdata time
set format x '%a %d'
set xtics 86400 scale 1.0,0.0
set xrange [ '{xrange_start}' : '{xrange_end}' ]

set ylabel 'Time'
set ydata time
set format y '%H:%M'
set yrange [ '2000-01-01T06:00:00' : '2000-01-01T23:00:00' ]

set key box opaque 
set terminal qt \
    persist \
    title 'opal-card-tool graph' \
    font 'Sans,10' \
    enhanced \
    size 1000,700

plot \
    '{data_pm_filename}' \
        using 1:2 \
        with line \
        title 'Afternoon departure time' \
    , \
    '{data_pm_filename}' \
        using 1:2:3 \
        with labels \
        offset 0,1 \
        notitle \
    , \
    '{data_am_filename}' \
        using 1:2 \
        with line \
        title 'Morning departure time' \
    , \
    '{data_am_filename}' \
        using 1:2:3 \
        with labels \
        offset 0,1 \
        notitle \
""".format(**d))

    def flush_files(self):
        for f in self.files:
            f.flush()

    def cleanup(self):
        for f in self.files:
            try:
                f.close()
            except:
                pass

    def run_gnuplot(self):
        subprocess.check_call([
            "gnuplot",
            self.plot_file.name,
        ])

def restrict_days(transaction_list, num_days):
    oldest_date = n_days_ago(num_days)
    for transaction in transaction_list:
        if transaction.timestamp < oldest_date:
            return
        yield transaction

def graph_commuter(transaction_list):
    g = CommuterGraph()
    g.graph(transaction_list)

def print_transaction_list(transaction_list):
    headers = []
    headers.extend(["number", "timestamp"])
    headers.extend(h for h in sorted(transaction_list[0].__dict__.keys()) if h not in headers)

    out = csv.DictWriter(sys.stdout, headers)
    out.writeheader()
    for transaction in transaction_list:
        out.writerow(transaction.__dict__)

def print_cards(opal):
    for i, card in enumerate(opal.cards):
        print("Card", i)
        print("  number:", card.number)
        print("  name:", card.name)
        print("  transactions:", len(card.transaction_list))
        print()

def try_unpickle():
    if not os.path.isfile(PICKLE_FILE):
        return None

    with open(PICKLE_FILE, "rb") as f:
        return pickle.load(f)

def save_pickle(opal):
    if not os.path.isdir(CACHE_DIR):
        os.makedirs(CACHE_DIR)
    with open(PICKLE_FILE, "wb") as f:
        pickle.dump(opal, f)



def upgrade_opal_v2(opal):
    # example upgrade!
    opal.version = 3

def upgrade_opal(opal):
    while opal.version < VERSION:
        print("Upgrading from version", opal.version, file=sys.stderr)
        upgrade_func = globals()["upgrade_opal_v%d" % opal.version]
        upgrade_func(opal)



def load_opal():
    opal = try_unpickle()

    if opal:
        upgrade_opal(opal)
        opal.init()
    else:
        username = input("Username: ")
        password = getpass.getpass()
        opal = Opal(username, password)

    save_pickle(opal)
    return opal

def do_load():
    opal = load_opal()
    opal.login()
    opal.load()
    save_pickle(opal)

def do_show_cards():
    opal = load_opal()
    print_cards(opal)
    save_pickle(opal)

def do_print(args):
    opal = load_opal()

    if args.card_number:
        card_number = args.card_number
    else:
        card_number = 0
    card_number = opal.resolve_card_number(card_number)

    if args.num_days:
        num_days = int(args.num_days)
    elif args.graph_commuter:
        num_days = 14
    else:
        num_days = 365

    transaction_list = opal.get_transaction_list_for_card(card_number)
    transaction_list = list(restrict_days(transaction_list, num_days))

    if not transaction_list:
        print("No transactions!", file=sys.stderr)
        return

    if args.show_transactions:
        print_transaction_list(transaction_list)
    elif args.graph_commuter:
        graph_commuter(transaction_list)
    else:
        print("Missing display function!", file=sys.stderr)

def parse_args():
    parser = argparse.ArgumentParser(description="Opal card activity fetcher")

    parser.add_argument("--num-days",
        help="restrict to NUM_DAYS of output"
    )
    parser.add_argument("--card-number",
        help="Opal card number or index (eg: 0,1,etc"
    )

    group = parser.add_mutually_exclusive_group(required=True)
    group.add_argument("--load", action="store_true",
        help="load any new data from the Opal website"
    )
    group.add_argument("--show-cards", action="store_true",
        help="show a list of cards"
    )
    group.add_argument("--show-transactions", action="store_true",
        help="show transactions for card"
    )
    group.add_argument("--graph-commuter", action="store_true",
        help="draw commuter graph for card with gnuplot"
    )

    args = parser.parse_args()

    return args

def main():
    args = parse_args()

    if args.load:
        do_load()
        return

    elif args.show_cards:
        do_show_cards()
        return

    else:
        do_print(args)

if __name__ == "__main__":
    try:
        main()
    except (KeyboardInterrupt, BrokenPipeError) as e:
        print("Exiting:", e, file=sys.stderr)
        sys.exit(1)

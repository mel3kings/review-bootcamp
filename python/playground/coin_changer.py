map = {
    50: 0,
    25: 0,
    10: 0,
    5: 0,
    1: 0,
}


def coin_changer(amountOfChange):
    temp = amountOfChange
    while temp != 0:
        for key in map.keys():
            multiples = temp // key
            temp -= (key * multiples)
            map[key] += multiples
    print(map)
    return


coin_changer(78)

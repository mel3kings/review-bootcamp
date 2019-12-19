class cotton:
    def __init__(self, val):
        self.data = val


class feather:
    def __init__(self, val):
        self.data = val


class iron:
    def __init__(self, val):
        self.data = val


class random:
    def __init__(self, val):
        self.data = val


conversion = {
    cotton: {feather: 2, random: 0},
    feather: {iron: 4},
}


def convert(amount, objectfrom, objectto, path=[]):
    if objectfrom == objectto:
        print('successfully converted')
        return
    if type(objectfrom) not in conversion:
        print('conversion not found')
        return
    for inner in conversion[type(objectfrom)]:
        for converter in inner:
            print(converter)
        # convert(amount * inner_conversion[converter], converter, objectto, path.append(converter))


cotton = cotton(1)
iron = iron(4)
convert(1, cotton, iron)

class picker():
    def __init__(self):
        self.has_block = False
        self.location = 0

    def pickup(self):
        self.location = 0
        self.has_block = True

    def move(self):
        self.location += 1

    def lower(self):
        self.has_block = False


input = "PMLPMLPMMML"
r = picker()
width = 10
places = [0] * width

for i in input:
    print(i)
    if i == "P":
        r.pickup()
    elif i == "M":
        r.move()
    elif i == "L":
        r.lower()
        places[r.location] += 1
print(places)
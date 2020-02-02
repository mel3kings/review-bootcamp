class Test:
    def __init__(self, val):
        self.val = val


class Item:
    def __init__(self, cost, name, weight):
        self.cost = cost
        self.name = name
        self.weight = weight

    def print(self):
        print('hello')

    def __str__(self):
        return self.name


def dynamic_programming(item_list=[]):
    grid = [[] for i in range(0, len(item_list) + 1)]
    grid[0] = [0 ,1, 2, 3, 4]
    x = 1
    for item in item_list:
        grid[x] = [0] * 5
        grid[x][0] = item
        x += 1
    print('\n'.join(['\t'.join([str(cell) for cell in row]) for row in grid]))

    current_item = None
    for i in range(0, len(grid)):
        for j in range(0, len(grid[i])):
            if i == 0:
                continue
            else:
                curr = grid[i][j]
                print(isinstance(grid[i][j], Item))
                if isinstance(grid[i][j], Item):
                    current_item = grid[i][j]
                elif current_item is not None and current_item.weight <= grid[0][j]:
                    grid[i][j] = current_item.cost

    print('\n'.join(['\t'.join([str(cell) for cell in row]) for row in grid]))


#
# for item in item_list:
#     grid[0][i] = item
#     grid[0][1] =[0]*8
#
# for i in grid:
#     for j in grid:
#         print(j)


laptop = Item(3500, "lp", 3)
cellphone = Item(1500, "cp", 2)
ps5 = Item(2500, "ps", 2)
laptop.print()
print(laptop)
lists = [cellphone, ps5, laptop]
dynamic_programming(lists)

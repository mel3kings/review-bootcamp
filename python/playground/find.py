class Node(object):
    def __init__(self, left, right, val):
        self.left = left
        self.right = right
        self.val = val


def find_graph(start, end, maps, path=[]):
    path.append(start)
    if start == end:
        print('found path ', path)
        return path
    if start not in maps:
        return
    for i in maps[start]:
        print(i)
        if i not in path:
            find_graph(i, end, maps, path)
            return
    print(path)
    return path


# a->c
mapping = {'a': 'b',
           'b': ['c', 'h'],
           'x': ['d'],
           'd': 'e',
           'e': 'f',
           'f': 'h'}

find_graph("a", "h", mapping, [])

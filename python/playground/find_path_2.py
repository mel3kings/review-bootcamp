#   a
#  / \
#  b  c
#    / \
#   d   e

# a -> e

possible_path = {'a': ['b', 'c'],
                 'b': ['c'],
                 'c': ['d', 'e']
                 }

parents = {
    'a': 'a',
}


def find_path(current, find, traversed=[]):
    if current in traversed:
        return find
    traversed.append(current)
    if current == find:
        print("found")
        print(traversed)
        return find
    if current in possible_path:
        for i in possible_path[current]:
            parents[i] = current
            find_path(i, find, traversed)


look = "e"
find_path("a", look, []);
if parents[look] is not None:
    while parents[look] != look:
        print("traversal :" + look)
        look = parents[look]
    print("traversal :" + look)
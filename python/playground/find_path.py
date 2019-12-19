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

def find_path(fro='a', to='e', current_path=[]):
    if fro == to:
        return current_path
    if fro not in possible_path:
        return
    for i in possible_path[fro]:
        if i != '':
            current_path.append(i)
            find_path(i, to, current_path)
    return current_path



path = find_path()
print(path)


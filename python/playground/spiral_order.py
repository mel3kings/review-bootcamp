def spiralOrder(matrix):
    """
    :type matrix: List[List[int]]
    :rtype: List[int]
    """
    display_set = []
    already_visited = set()
    while len(matrix) > 0:
        i = j = 0
        for i in range(0, len(matrix)):
            #  print('j i', j, i)
            # print(matrix[j][i])
            val = matrix[j][i]
            if val not in already_visited:
                display_set.append(matrix[j][i])
                already_visited.add(matrix[j][i])
        for j in range(0, len(matrix[i])):
            # print('j i', j, i)
            # print(matrix[j][i])
            val = matrix[j][i]
            if val not in already_visited:
                display_set.append(matrix[j][i])
                already_visited.add(matrix[j][i])
        for i in reversed(range(0, len(matrix))):
            # print('rev j i', j, i)
            # print(matrix[j][i])
            val = matrix[j][i]
            if val not in already_visited:
                display_set.append(matrix[j][i])
                already_visited.add(matrix[j][i])
        for j in reversed(range(0, len(matrix[i]))):
            # print('rev j i', j, i)
            # print(matrix[j][i])
            val = matrix[j][i]
            if val not in already_visited:
                display_set.append(matrix[j][i])
                already_visited.add(matrix[j][i])
        #   print(matrix[i][j])
        matrix = [row[1:len(matrix) - 1] for row in matrix[1:len(matrix) - 1]]
    # print(display_set)
    return display_set


# spiralOrder([
#     [0, 1, 2, 3],
#     [10, 11, 12, 13],
#     [20, 21, 22, 23],
#     [30, 31, 32, 33]
# ])

spiralOrder([
    [0, 1, 2, 3],
    [10, 11, 12, 13],
    [20, 21, 22, 23]
])
#
# [1, 2, 3]
# [1, 2, 3]
# [1, 2, 3]
#

#
# 00 01 02 03 13 23 33 32 31 30 20 10 11 12 22 21
# 00 01 02 03 10 11 12 13 20 21 22 23 30 31 32 33

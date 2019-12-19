def rotate_me(arr, target):
    size = len(arr)
    holder = [0] * size
    target = target % size + 1
    j = 0
    for i in range(target, size):
        holder[j] = arr[i]
        j += 1
    for i in range(0, target):
        holder[j] = arr[i]
        j += 1
    return holder




print(rotate_me([1, 2, 3, 4, 5, 6, 7], 3))

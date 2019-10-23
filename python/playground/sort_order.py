def sort_order(array):
    if len(array) == 0:
        return
    i = 0
    holder = array[i]
    for j in range(len(array)):
        current_val = array[j]
        if current_val > holder:
            i += 1
            array[i] = current_val
            holder = current_val

    print(array)


sort_order([1, 1, 1, 2, 2, 3, 3, 4])

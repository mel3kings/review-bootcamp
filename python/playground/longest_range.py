def longest_range(arr):
    arr.sort()
    start = end = 0
    longest_end = longest_start = 0
    for idx in range(len(arr)):
        current_val = arr[idx]
        if end == 0:
            start = end = arr[idx]
        prev = arr[idx - 1]
        if idx > 0 and prev == current_val - 1:
            end = arr[idx]
            if end - start > longest_end - longest_start:
                longest_end = end
                longest_start = start
        else:
            start = end = arr[idx]
    print(longest_start, longest_end)


longest_range([2, 23, 3, 6, 5, 4, 1, 10, 11, 12, 0, 13, 14, 15, 16])

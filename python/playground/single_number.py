def find_single(nums):
    count_map = {}
    for i in range(len(nums)):
        current = nums[i]
        if current in count_map:
            count_map[current] = count_map[current] + 1
        else:
            count_map[current] = 1

    for k, v in count_map.items():
        if v == 1:
            return k
    return None



print(find_single([1, 1, 2]))

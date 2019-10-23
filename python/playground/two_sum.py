def two_sum(numbers, target):
    if len(numbers) == 0:
        return []
    two_sums_map = {}
    for i, current in enumerate(numbers):
        diff = target - current
        if diff in two_sums_map:
            return [two_sums_map[target - current], i]
        two_sums_map[current] = i
    return []


print(two_sum([2, 15, 9, 7], 9))



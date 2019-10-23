class Solution:
    def buy_sell(self, nums):
        profit = 0
        size = len(nums)
        if size == 0:
            return profit

        difference = [0] * size
        for i in range(1, size):
            j = i + 1
            if j < size:
                difference[i] = nums[j] - nums[i]

        for i in range(len(difference)):
            if difference[i] > 0:
                profit += difference[i]
        return profit


clas = Solution()
print(clas.buy_sell([7, 1, 5, 3, 6, 4]))

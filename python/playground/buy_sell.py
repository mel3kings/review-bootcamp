class Solution:
    def buy_sell(self, prices):
        profit = 0
        size = len(prices)
        if size == 0:
            return profit

        difference = [0] * size
        for i in range(1, size):
            j = i + 1
            if j < size:
                difference[i] = prices[j] - prices[i]

        for i in range(len(difference)):
            if difference[i] > 0:
                profit += difference[i]
        return profit


clas = Solution()
print(clas.buy_sell([1, 2, 3, 4, 5]))

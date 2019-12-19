class Solution(object):
    def rotate(self, matrix):
        n = len(matrix)
        for i in range(n):
            for j in range(i):
                print(i, j)
                print("swapping:", matrix[i][j], matrix[j][i])
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        print(matrix)


test = Solution()
test.rotate([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
# 1,2,3
# 4,5,6
# 7,8,9

# i - 0, j - 0
# x - 3
# ij ->(x-i)i
# jx ->ij
# x(x-j) ->jx
# (x-j)i -> x(x-j)

# holder = ij
# holder2 = jx
# holder3= x(x-j)
# ij ->(x-i)i
# jx ->holder
# x(x-j) -> holder2
# (x-j)i -> holder3

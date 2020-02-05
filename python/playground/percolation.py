class Percolation:
    def __init__(self, size):
        self.grid = [[]] * size
        for i in range(size):
            self.grid[i] = [0] * size
        counter = 0
        for i in range(size):
            for j in range(size):
                self.grid[i][j] = counter
                counter = counter + 1


class UnionJoin:
    def __init__(self, size):
        self.array = [0] * size
        for i in range(size):
            self.array[i] = i

    def find_root(self, index):
        while self.array[index] != index:
            index = self.find_root(self.array[index])
        return index

    def union(self, i, j):
        self.array[self.find_root(i)] = self.array[self.find_root(j)]

    def is_connected(self, i, j):
        i_root = self.find_root(self.array[self.find_root(i)])
        j_root = self.find_root(self.array[self.find_root(j)])
        return i_root == j_root

    def print(self):
        for i in self.array:
            print(self.array[i])


p = Percolation(3)
print(p.grid)
uj = UnionJoin(12)
uj.union(0, 10)
uj.union(1, 10)
uj.union(2, 10)

uj.union(7, 11)
uj.union(8, 11)
uj.union(9, 11)

uj.union(1, 5)
uj.union(5, 7)
print(uj.is_connected(1, 7))

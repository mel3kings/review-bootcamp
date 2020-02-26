class node:
    left = None
    right = None

    def __init__(self, value):
        self.value = value
        self.balance = 0

    def __str__(self):
        return self.value

    def insert(self, input):
        if self.value < input.value:
            self.balance += 1
            if self.right is not None:
                self.right.insert(input)
            else:
                self.right = input
        else:
            self.balance -= 1
            if self.left is not None:
                self.left.insert(input)
            else:
                self.left = input

    def print(self):
        if self.left is not None:
            print("left is {}".format(self.left.value))
        if self.right is not None:
            print("right is {}".format(self.right.value))
        print("value is {}".format(self.value))
        print("balance is {}".format(self.balance))

    def avl(self):
        if self.balance >= 2:
            self.balance = 0
            rotate_left = self.right
            self.right = None
            rotate_left.left = self
        elif self.balance <= -2:
            self.balance = 0
            rotate_right = self.left
            self.left = None
            rotate_right.right = self


#   4
# 3   5
#       6
#         7
#
#     5
#   4   6
# 3       7


three = node(3)
five = node(5)
print(-3 < -2)

root = node(4)
root.insert(three)
root.insert(five)
root.print()
#
six = node(6)
seven = node(7)
root.insert(six)
root.insert(seven)
root.avl()
root.print()

#
# a) Left Left Case
#
# T1, T2, T3 and T4 are subtrees.
#          z                                      y
#         / \                                   /   \
#        y   T4      Right Rotate (z)          x      z
#       / \          - - - - - - - - ->      /  \    /  \
#      x   T3                               T1  T2  T3  T4
#     / \
#   T1   T2
# b) Left Right Case
#
#      z                               z                           x
#     / \                            /   \                        /  \
#    y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
#   / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
# T1   x                          y    T3                    T1  T2 T3  T4
#     / \                        / \
#   T2   T3                    T1   T2
# c) Right Right Case
#
#   z                                y
#  /  \                            /   \
# T1   y     Left Rotate(z)       z      x
#     /  \   - - - - - - - ->    / \    / \
#    T2   x                     T1  T2 T3  T4
#        / \
#      T3  T4
# d) Right Left Case
#
#    z                            z                            x
#   / \                          / \                          /  \
# T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
#     / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
#    x   T4                      T2   y                  T1  T2  T3  T4
#   / \                              /  \
# T2   T3                           T3   T4

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        finished = False
        carry = 0
        response = None
        while not finished:
            sum1 = 0
            sum2 = 0
            if l1 is None and l2 is None:
                break
            if l1 is not None:
                sum1 = l1.val
            if l2 is not None:
                sum2 = l2.val
            result = sum1 + sum2
            if carry > 0:
                result = result + carry
                carry = 0
            if result > 10:
                carry = 1
                result = result - 10
            next_response = ListNode(result)
            if response is None:
                response = next_response
            else:
                response.next = next_response
            l1 = l1.next
            l2 = l2.next
        return response


two = ListNode(6)
four = ListNode(0)
three = ListNode(1)

two.next = four
four.next = three

solution = Solution()
res = solution.addTwoNumbers(two, two)
print(res)
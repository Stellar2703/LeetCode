# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def GCD(a, b):
            while b:
                a, b = b, a % b
            return a
        
        p1 = head
        p2 = p1.next

        while p1 and p1.next:
            value = GCD(p1.val,p2.val)
            node = ListNode(value)
            p1.next = node
            node.next = p2
            p1 = p2
            p2 = p2.next
        return head



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy

        while head and head.next:

            p1 = head
            p2 = head.next

            prev.next = p2
            p1.next = p2.next
            p2.next  = p1

            prev = p1
            head = p1.next
        
        return dummy.next

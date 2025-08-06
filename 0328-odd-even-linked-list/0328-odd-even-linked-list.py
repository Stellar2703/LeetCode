# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        if not head or not head.next:
            return head
        
        odd = head
        even = head.next
        p1 = odd
        p2 = even
        while p2 and p2.next:
                p1.next = p2.next
                p1 = p1.next
                p2.next = p1.next
                p2 = p2.next
        p1.next = even
        return head

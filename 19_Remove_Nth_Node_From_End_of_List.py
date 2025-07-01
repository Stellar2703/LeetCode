# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        cur = head
        count = 0

        # Count the number of nodes
        while cur:
            count += 1
            cur = cur.next

        # Find the node before the one to delete
        cur = dummy
        for _ in range(count - n):
            cur = cur.next

        # Delete the target node
        cur.next = cur.next.next if cur.next else None

        return dummy.next
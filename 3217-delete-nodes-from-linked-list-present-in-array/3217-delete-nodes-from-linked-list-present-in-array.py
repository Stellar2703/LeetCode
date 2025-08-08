# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        to_remove = set(nums)  # O(1) lookups
        dummy = ListNode(0)
        dummy.next = head
        ptr = dummy

        while ptr and ptr.next:
            if ptr.next.val in to_remove:
                ptr.next = ptr.next.next  # skip this node
            else:
                ptr = ptr.next  # move forward only if not deleting

        return dummy.next
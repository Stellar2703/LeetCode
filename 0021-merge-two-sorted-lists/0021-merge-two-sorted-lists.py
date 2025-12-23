# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        curr1 = list1
        curr2 = list2
        dummy = ListNode(-1)
        ptr = dummy
        while curr1 and curr2:
            if (curr1.val>=curr2.val):
                ptr.next = curr2
                curr2 = curr2.next
                ptr=ptr.next
            else:
                ptr.next = curr1
                curr1 = curr1.next
                ptr=ptr.next
        if curr1:
            ptr.next  = curr1
        if curr2:
            ptr.next = curr2
        return dummy.next

    # def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    #     if not list1:
    #         return list2
    #     if not list2:
    #         return list1

    #     if list1.val < list2.val:
    #         list1.next = self.mergeTwoLists(list1.next, list2)
    #         return list1
    #     else:
    #         list2.next = self.mergeTwoLists(list1, list2.next)
    #         return list2
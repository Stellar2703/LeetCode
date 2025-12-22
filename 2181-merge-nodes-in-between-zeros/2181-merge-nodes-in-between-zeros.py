# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # ptr = head.next
        # summ =0
        # temp = ListNode(0)
        # head1 = temp
        # while (ptr):
        #     if(ptr.val == 0 ):
        #         te = ListNode(summ)
        #         temp.next = te
        #         temp = temp.next
        #         summ = 0
        #     summ+=ptr.val
        #     ptr=ptr.next
        # return head1.next
        ptr = head.next
        summ =0
        start = head
        ptr1=head
        while (ptr):
            if(ptr.val == 0 ):
                start.val = summ
                ptr1= start
                start=start.next
                summ = 0
            summ+=ptr.val
            ptr=ptr.next
        ptr1.next = None
        return head

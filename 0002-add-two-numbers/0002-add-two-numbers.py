# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        curr1 = l1
        curr2  = l2
        carry = 0
        dummy = ListNode(-1)
        temp = dummy
        while(curr1 or curr2 or carry!=0):
            summ = 0
            if(curr1):
                summ+=curr1.val
                curr1=curr1.next
            if(curr2):
                summ+=curr2.val
                curr2=curr2.next
            summ+=carry
            value = summ%10
            carry = summ//10
            n = ListNode(value)
            temp.next = n
            temp = temp.next
        return dummy.next


            


    




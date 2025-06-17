class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # cur1 = headA
        # cur2 = headB
        # while cur1:
        #     while cur2:
        #         if cur1 == cur2:
        #             return cur1
        #         cur2=cur2.next
        #     cur2 = headB
        #     cur1 = cur1.next
        # return None

        a,b = headA,headB
        while a!=b:
            a = a.next if a else headB
            b = b.next if b else headA
        return a
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k == 0:
            return head

        # Step 1: Find length and tail
        length = 1
        tail = head
        while tail.next:
            tail = tail.next
            length += 1

        # Step 2: Normalize k
        k = k % length
        if k == 0:
            return head

        # Step 3: Find new tail (length - k - 1 steps from head)
        new_tail = head
        for _ in range(length - k - 1):
            new_tail = new_tail.next

        # Step 4: New head is after new_tail
        new_head = new_tail.next

        # Step 5: Rotate
        new_tail.next = None
        tail.next = head

        return new_head

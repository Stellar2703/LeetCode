class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;

        // Move first to k-th node from beginning
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode kthFromStart = first;

        // Use first pointer to reach end
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        ListNode kthFromEnd = second;

        // Swap values
        int temp = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = temp;

        return head;
    }
}
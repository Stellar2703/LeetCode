/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev_l = null;
        int count = 1;
        while(count <left){
            prev_l = curr;
            curr = curr.next;
            count ++;
        }
        ListNode start_l = curr;
        ListNode prev = prev_l;
        while(count<=right){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (prev_l != null) {
            prev_l.next = prev;
        } else {
            head = prev;  // when left == 1
        }
        start_l.next = curr;
        return head;
    }
}
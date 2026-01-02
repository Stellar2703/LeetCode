/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(fast==null) return false;
        while(fast.next!=null){
            if(fast==slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
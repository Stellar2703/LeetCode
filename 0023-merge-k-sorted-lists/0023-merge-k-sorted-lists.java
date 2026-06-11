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
    public ListNode mergeKLists(ListNode[] lists) {
        //M1: priority queue

        PriorityQueue<Integer> pq= new PriorityQueue<>();

        for(ListNode list: lists){
            ListNode node= list;
            while(node!=null){
                pq.add(node.val);
                node= node.next;
            }
        }
        ListNode ans= new ListNode(-1);
        ListNode head= ans;

        while(!pq.isEmpty()){
            ListNode node= new ListNode(pq.poll());
            head.next= node;
            head= head.next;
        }

        return ans.next;
    }
}
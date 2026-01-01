/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode _node,int _index){
        this.node = _node;
        this.index=_index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue <Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int start = q.peek().index;
            int end = start;
            for (int i =0 ;i<size;i++){
                Pair temp = q.poll();
                end = temp.index;
                int idx = end-start+1;
                max = Math.max(max,idx);
                if(temp.node.left != null){
                    q.offer(new Pair (temp.node.left,temp.index*2+1));
                }
                if(temp.node.right != null){
                    q.offer(new Pair (temp.node.right,temp.index*2+2));
                }
            }
        }
        return max;
    }
}
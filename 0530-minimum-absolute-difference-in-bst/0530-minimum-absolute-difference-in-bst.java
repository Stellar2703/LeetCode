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
class Solution {
    Integer prev = null;
    int min = Integer.MAX_VALUE;
    public void absolute(TreeNode root){
        if(root==null) return;
        absolute(root.left);
        if(prev!= null && Math.abs(prev-root.val)<min){
            min = Math.abs(prev-root.val);
        }
        prev  = root.val;
        absolute(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        absolute(root);
        return min;
    }
}
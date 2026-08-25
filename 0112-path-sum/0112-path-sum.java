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
    public boolean f(TreeNode root , int targetSum){
        if(root== null){
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        boolean left = f(root.left,targetSum-root.val);
        boolean right = f(root.right,targetSum-root.val);
        return left || right;

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return f(root,targetSum);
    }
}
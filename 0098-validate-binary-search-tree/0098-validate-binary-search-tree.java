/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *      long val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode( long val) { this.val = val; }
 *     TreeNode( long val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean f(TreeNode root,  long min, long max){
        if(root == null) return true;
        if(root.val<=min || root.val>=max) return false;
        // if(root.val>min && root.val<max) return true;  stop the recursion calls befor the node is 
        // seacrched completely.
        return f(root.left,min,root.val) && f(root.right,root.val,max);

    }
    public boolean isValidBST(TreeNode root) {
        return f(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
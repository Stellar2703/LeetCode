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
    int maxi  = 0;
    public void f(TreeNode root,int min,int max){
        if(root == null) return;
        maxi = Math.max(maxi,Math.abs(root.val-min));
        maxi= Math.max(maxi,Math.abs(root.val-max));

        min = Math.min(min,root.val);
        max = Math.max(max,root.val);

        f(root.left,min,max);
        f(root.right,min,max);
    }
    public int maxAncestorDiff(TreeNode root) {
        f(root,root.val,root.val);
        return maxi;
    }
}
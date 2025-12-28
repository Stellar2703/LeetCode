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
    int maxi = 0;
    int f(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = f(root.left);
        int rh = f(root.right);
        int d = lh+rh;
        if(d > maxi){
            maxi =d;
        }
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int h = f(root);
        return maxi;

    }
}
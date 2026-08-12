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
    TreeNode tar;
    boolean ans = false;
    public void f(TreeNode root,TreeNode target){
        if(root == null)  return;
        if(root.val == target.val){
           if(f1(root,target))ans = true;
        }
        f(root.left,target);
        f(root.right,target);
    }

    public boolean f1(TreeNode root1,TreeNode root2){

        if(root1 == null && root2 == null) return true;
        if(root1== null || root2 == null) return false;
        if(root1.val!=root2.val) return false;
        boolean left = f1(root1.left,root2.left);
        boolean right  = f1(root1.right,root2.right);
        return left && right;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        f(root,subRoot);
        return ans;
    }
}
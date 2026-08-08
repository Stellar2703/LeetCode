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
    // public int f(TreeNode root){
    //     if(root == null) return 0;

    //     int left = f(root.left);
    //     int right = f(root.right);

    //     return 1+left+right;
    // }

    public int find_height_left(TreeNode root){
        if(root == null) return 0;
        return 1+find_height_left(root.left);
    }
    public int find_height_right(TreeNode root){
        if(root == null) return 0;
        return 1+find_height_right(root.right);
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int left = find_height_left(root.left);
        int right = find_height_right(root.right);

        if(left == right) return (2<<left) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);

    }
} 
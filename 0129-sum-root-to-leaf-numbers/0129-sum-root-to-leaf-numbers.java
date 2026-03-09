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
    public void f(TreeNode root,int[] sum,int num){
        if(root==null) return;
        int temp = num*10+root.val;

        if(root.left==null && root.right==null){
            sum[0]+=temp;
        }
        else{
            f(root.left,sum,temp);
            f(root.right,sum,temp);
        }   
    }
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        f(root,sum,0);
        return sum[0];
    }
}
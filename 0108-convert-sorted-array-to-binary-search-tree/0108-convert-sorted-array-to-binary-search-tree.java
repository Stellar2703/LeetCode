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
    public TreeNode f(int left,int right,int[] nums){
        if(right<left) return null;
        TreeNode root = new TreeNode();
        // int mid = (right-left)/2;
        int mid = left + (right - left) / 2;
        root.val = nums[mid];
        root.left = f(left,mid-1,nums);  
        root.right = f(mid+1,right,nums);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return f(0,nums.length-1,nums);
    }
}
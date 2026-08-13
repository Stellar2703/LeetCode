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
    ArrayList<Integer> arr1;
    ArrayList<Integer> arr2;
    public void f(TreeNode root,List<Integer> arr){
        if(root== null) return;
        if(root.right == null && root.left == null){
            arr.add(root.val);
            return;
        }
        f(root.left,arr);
        f(root.right,arr);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        arr1 = new ArrayList<>();
        arr2 = new ArrayList<>();
        f(root1,arr1);
        f(root2,arr2);
        return arr1.equals(arr2);
    }
}
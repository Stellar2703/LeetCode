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
    public void f(TreeNode root, int target,int sum,ArrayList<Integer> temp,List<List<Integer>> ans){
        if(root==null) return;

        temp.add(root.val);
        sum+=root.val;

        if(root.left == null && root.right==null && sum == target){
            ans.add(new ArrayList<>(temp));
        }
        else{
            f(root.left,target,sum,temp,ans);
            f(root.right,target,sum,temp,ans);
        }
        
        temp.remove(temp.size()-1);        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans =  new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        f(root,targetSum,0,temp,ans);
        return ans;
    }
}
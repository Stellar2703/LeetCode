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
    public void path(TreeNode root,List<String> ans,StringBuilder temp){
        if(root == null) return;
        int len = temp.length();
        temp.append(root.val);

        if((root.left == null) && (root.right==null)){
            ans.add(temp.toString());
        }
        else{
        temp.append("->");
        path(root.left,ans,temp);
        path(root.right,ans,temp);
        }
        temp.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        path(root,ans,temp);
        return ans;
    }
}
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
    public TreeNode f(TreeNode root, HashSet<Integer> del,ArrayList<TreeNode> ans){
        if(root==null) return null;
        root.left = f(root.left,del,ans);
        root.right= f(root.right,del,ans);
         if(del.contains(root.val)){
            if(root.left!=null)ans.add(root.left);
            if(root.right!=null)ans.add(root.right);
            return null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> del = new HashSet<>();
        for(int i=0;i<to_delete.length;i++){
            del.add(to_delete[i]);
        }
        ArrayList<TreeNode> ans = new ArrayList<>();
        TreeNode last = f(root,del,ans);
        ans.add(last);
        return ans;
    }
}
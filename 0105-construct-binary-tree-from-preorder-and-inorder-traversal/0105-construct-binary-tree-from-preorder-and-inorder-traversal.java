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
    int present_index = 0;
    public TreeNode getTree(int[] preorder,HashMap<Integer,Integer> mp,int left,int right){
        if(left>right) return null;
        int temp_index = present_index;
        TreeNode root = new TreeNode (preorder[present_index++]);

        root.left = getTree(preorder,mp,left,mp.get(preorder[temp_index])-1);
        root.right = getTree(preorder,mp,mp.get(preorder[temp_index])+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<preorder.length;i++){
            mp.put(inorder[i],i);
        }
        return getTree(preorder,mp,0,preorder.length-1);

    }
}
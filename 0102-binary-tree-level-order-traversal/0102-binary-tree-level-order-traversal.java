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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> st = new LinkedList<>();
        if(root == null) return ans;
        st.offer(root);
        while(!st.isEmpty()){
            int size  = st.size();
            ArrayList<Integer> temp  = new  ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = st.poll();
                temp.add(node.val);
                if(node.left!=null) {
                    st.offer(node.left);
                } 
                if(node.right!=null) {
                    st.offer(node.right);
                }
            }
            ans.add(temp);
        }
            return ans;
    }
}
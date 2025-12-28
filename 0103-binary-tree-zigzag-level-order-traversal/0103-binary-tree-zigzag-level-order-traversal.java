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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int l=0;
        while (!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int s = q.size();
            for (int i = 0 ; i<s;i++){
                TreeNode node =q.poll();
                if (node == null){
                    return ans;
                }
                temp.add(node.val);
                if(node.right!=null){
                    q.offer(node.right);
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
            }
            if(l%2==0){
                Collections.reverse(temp);
            }
            ans.add(temp);
            l++;
        }
        return ans;
    }
}
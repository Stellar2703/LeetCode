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


//  class Solution {
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         int max = Integer.MIN_VALUE;
//         if(root == null) return ans;
//         q.offer(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             max = Integer.MIN_VALUE;
//             for(int i=0;i<size;i++){
//                 TreeNode node = q.poll();
//                 if(node.left!= null) q.offer(node.left);
//                 if(node.right!= null) q.offer(node.right);
//                 if(node.val > max) max = node.val;
//             }
//             ans.add(max);
//         }
//         return ans;
//     }
// }


class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,0,ans);
        return ans;
    }

    private void dfs(TreeNode root,int level,List<Integer> ans ){
        if(root==null) return;
        if(ans.size()==level){
            ans.add(root.val);
        }
        else{
            ans.set(level, Math.max(ans.get(level), root.val));
        }
        dfs(root.left,level+1,ans);
        dfs(root.right,level+1,ans);
    }
}
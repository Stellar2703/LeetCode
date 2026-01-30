/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        while(!q.isEmpty()){
            TreeNode node  = q.poll();
                if(node.right!= null) {
                    parent.put(node.right,node);
                    q.offer(node.right);}
                if(node.left!= null) {
                    parent.put(node.left,node);
                    q.offer(node.left);}
            }
        q.clear();
        q.offer(target);
        int dist = 0;
        HashSet<TreeNode> vis = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        vis.add(target);
        while(!q.isEmpty() && dist<k){
            int n = q.size();
            for(int i =0;i<n;i++){
                TreeNode node = q.poll();
                if(node.left!=null && !vis.contains(node.left)){
                 q.offer(node.left);
                 vis.add(node.left);}
                if(node.right!=null && !vis.contains(node.right)) {
                    q.offer(node.right);
                    vis.add(node.right);}
                if(parent.containsKey(node) && !vis.contains(parent.get(node))) {
                    q.offer(parent.get(node));
                    vis.add(parent.get(node));}
            }
            dist++;
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}
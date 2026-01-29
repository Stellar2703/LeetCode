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
        // Do traversal to get the parent elements

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        HashMap<TreeNode,TreeNode> mp = new HashMap<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
             mp.put(node.left,node);
             q.offer(node.left);
            }
            if(node.right!= null){
                mp.put(node.right,node);
                q.offer(node.right);
            }
        }
        q.clear();
        HashSet<TreeNode> visited = new HashSet<>();
        int dist = 0;
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty() && dist<k){
            int size = q.size();
            for(int i=0;i<size;i++){
            TreeNode node = q.poll();
            if(node.left!=null && !visited.contains(node.left)) {
                q.offer(node.left);
                visited.add(node.left);}
            if(node.right!= null && !visited.contains(node.right)){
                q.offer(node.right);
                visited.add(node.right);
            } 
            if(mp.containsKey(node)&& !visited.contains(mp.get(node))) {
                q.offer(mp.get(node));
                visited.add(mp.get(node));}
            }
            dist++;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}
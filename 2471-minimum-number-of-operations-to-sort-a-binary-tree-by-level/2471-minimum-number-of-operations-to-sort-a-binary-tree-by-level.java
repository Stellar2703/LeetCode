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

    public int swaps_req(ArrayList<Integer> arr){
        int n = arr.size();
        ArrayList<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);
        int swaps = 0;
        for(int i =0;i<n;i++){
            if(arr.get(i)!=sorted.get(i)){
                int j = i+1;
                while(arr.get(j)!=sorted.get(i)){
                    j++;
                }
                arr.set(j,arr.get(i));
                arr.set(i,sorted.get(i));
                swaps++;
            }
        }
        return swaps;
    }
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            ans+= swaps_req(temp);
        }
        return ans;
    }
}
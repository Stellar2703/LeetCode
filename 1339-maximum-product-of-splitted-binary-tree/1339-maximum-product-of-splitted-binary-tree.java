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

    long total = 0;
    long ans = 0;
    int MOD = 1000000007;

    // Calculate total sum
    private void calc(TreeNode root){
        if(root == null) return;

        total += root.val;

        calc(root.left);
        calc(root.right);
    }

    // Returns subtree sum
    private long dfs(TreeNode root){
        if(root == null) return 0;

        long left = dfs(root.left);
        long right = dfs(root.right);

        long subTreeSum = root.val + left + right;

        ans = Math.max(ans, subTreeSum * (total - subTreeSum));

        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {

        calc(root);

        dfs(root);

        return (int)(ans % MOD);
    }
}
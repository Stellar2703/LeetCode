class Solution {

    Map<TreeNode, Integer> dp = new HashMap<>();

    private int f(TreeNode root) {
        if (root == null) return 0;

        if (dp.containsKey(root))
            return dp.get(root);

        int pick = root.val;

        if (root.left != null) {
            pick += f(root.left.left);
            pick += f(root.left.right);
        }

        if (root.right != null) {
            pick += f(root.right.left);
            pick += f(root.right.right);
        }

        int notPick = f(root.left) + f(root.right);

        int ans = Math.max(pick, notPick);

        dp.put(root, ans);

        return ans;
    }

    public int rob(TreeNode root) {
        return f(root);
    }
}
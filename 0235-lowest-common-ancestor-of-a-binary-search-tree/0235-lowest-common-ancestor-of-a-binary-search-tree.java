class Solution {

    public TreeNode f(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if ((root.val >= p.val && root.val <= q.val) ||
            (root.val <= p.val && root.val >= q.val)) {
            return root;
        }

        if (root.val > p.val && root.val > q.val) {
            return f(root.left, p, q);
        }

        if (root.val < p.val && root.val < q.val) {
            return f(root.right, p, q);
        }

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return f(root, p, q);
    }
}
class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        parent.put(root, null);

        while (!q.isEmpty()) {

            int size = q.size();

            TreeNode parentX = null;
            TreeNode parentY = null;

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if (node.val == x) {
                    parentX = parent.get(node);
                }

                if (node.val == y) {
                    parentY = parent.get(node);
                }

                if (node.left != null) {
                    q.offer(node.left);
                    parent.put(node.left, node);
                }

                if (node.right != null) {
                    q.offer(node.right);
                    parent.put(node.right, node);
                }
            }

            // Both found at this level
            if (parentX != null && parentY != null) {
                return parentX != parentY;
            }

            // Only one found at this level
            if (parentX != null || parentY != null) {
                return false;
            }
        }

        return false;
    }
}
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
        int pos = 0;
        public TreeNode f(int[] postorder,HashMap<Integer,Integer> mp , int left,int right){
            if (left > right) return null;

            TreeNode root  = new TreeNode(postorder[pos--]);
            root.right = f(postorder,mp,mp.get(root.val)+1,right);
            root.left = f(postorder,mp,left,mp.get(root.val)-1);

            return root;

        }
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int i=0;i<n;i++){
                mp.put(inorder[i],i);
            }
            pos = n-1;
            return f(postorder,mp,0,n-1);
        }
    }
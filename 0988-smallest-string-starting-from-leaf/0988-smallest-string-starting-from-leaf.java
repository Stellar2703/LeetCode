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
        String max = "~";
        public void lexi(TreeNode root,StringBuilder s){
            if(root == null) return;

            int size = s.length();
            s.append((char)(root.val +'a'));
            String temp =new StringBuilder(s).reverse().toString();
            if(root.right == null && root.left == null && temp.compareTo(max)<0){
                max  = temp;
            }
            else{
                lexi(root.left,s);
                lexi(root.right,s);
            }
            s.setLength(size);
        }

        public String smallestFromLeaf(TreeNode root) {
            StringBuilder s = new StringBuilder();

            lexi(root,s);
            return max;
        }
    }
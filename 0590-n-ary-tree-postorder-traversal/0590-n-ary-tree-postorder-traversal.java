/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    List<Integer> ans;
    public void f(Node root){
        if(root == null) return;

        for(Node c : root.children){
            f(c);
        }
        ans.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        ans = new ArrayList<>();
        f(root);
        return  ans;
    }
}
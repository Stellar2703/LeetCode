/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = getNext(root.next);
            }
        }

        if (root.right != null) {
            root.right.next = getNext(root.next);
        }

        // IMPORTANT: process right first
        connect(root.right);
        connect(root.left);

        return root;
    }

    private Node getNext(Node node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }
}



// class Solution {
//     public Node connect(Node root) {
//         if(root==null) return root;
//         Queue<Node> q = new LinkedList<>();
//         q.offer(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0;i<size;i++){
//                 Node node = q.poll();
//                 if(i == size-1) node.next = null;
//                 else node.next = q.peek();
//                 if(node.left!=null) q.offer(node.left);
//                 if(node.right != null) q.offer(node.right);
//             }
//         }
//         return root;
//     }
// }
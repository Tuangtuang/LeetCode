package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Node {

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


    public static Node InitTree(Integer[] vals) {
        Node root = new Node(vals[0]);
        Queue<Node> queue = new LinkedList<>();
        int cur = 1;
        queue.offer(root);
        while (queue != null) {
            Node r = queue.poll();
            if (vals[cur] == null) {
                r.left=null;
            } else {
                r.left = new Node(vals[cur]);
                queue.offer(r.left);
            }
            if (++cur >= vals.length) {
                break;
            }
            if (vals[cur] == null) {
                r.right = null;
            } else {
                r.right = new Node(vals[cur]);
                queue.offer(r.right);
            }
            if (++cur >= vals.length) {
                break;
            }
        }
        return root;
    }
}

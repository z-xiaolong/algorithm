package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/4/3 10:11
 * @Title 面试题36. 二叉搜索树与双向链表
 * @Description //TODO
 **/

public class TreeToDoublyList {

    public static void main(String[] args) {
        Node root = new Node(4);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        TreeToDoublyList list = new TreeToDoublyList();
        list.treeToDoublyList(root);
    }

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node min = root;
        Node max = root;
        if (root.left != null) min = getMin(root.left);
        if (root.right != null) max = getMax(root.right);
        recursion(root);
        min.left = max;
        max.right = min;
        return min;
    }

    public void recursion(Node node) {
        Node left = node.left;
        Node right = node.right;
        if (left != null) {
            Node max = getMax(left);
            node.left = max;
            recursion(left);
            max.right = node;
        }
        if (right != null) {
            Node min = getMin(right);
            node.right = min;
            recursion(right);
            min.left = node;
        }
    }

    public Node getMax(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return getMax(node.right);
        }
    }

    public Node getMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return getMin(node.left);
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}

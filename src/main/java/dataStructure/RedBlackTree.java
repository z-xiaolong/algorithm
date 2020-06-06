package dataStructure;

/**
 * @Author long
 * @Date 2020/5/1 17:55
 * @Title
 * @Description //TODO
 **/

public class RedBlackTree<T extends Comparable<T>> {

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private TreeNode<T> root;

    private void rotateLeft(TreeNode<T> node) {
        if (node == null) return;
        TreeNode<T> right = node.right;
        node.right = right.left;
        if (node.left != null) node.left.parent = node;

        right.parent = node.parent;
        if (node.parent == null) {
            root = right;
        } else if (node.parent.left == node) {
            node.parent.left = right;
        } else {
            node.parent.right = right;
        }

        right.left = node;
        node.parent = right;
    }

    private void rotateRight(TreeNode<T> node) {
        if (node == null) return;
        TreeNode<T> left = node.left;
        node.left = left.right;
        if (left.right != null) left.right.parent = node;

        left.parent = node.parent;
        if (node.parent == null) {
            root = left;
        } else if (node.parent.right == node) {
            node.parent.right = left;
        } else {
            node.parent.left = left;
        }

        left.right = node;
        node.parent = left;
    }

    static final class TreeNode<T extends Comparable<T>> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode<T> parent;
        boolean color = BLACK;
    }
}

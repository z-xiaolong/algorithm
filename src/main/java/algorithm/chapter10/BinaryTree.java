package algorithm.chapter10;

/**
 * @Author long
 * @Date 20:18 2019/10/18
 * @Title
 * @Description
 **/

public class BinaryTree<E> {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};
        BinaryTree<Integer> binaryTree = new BinaryTree<>(nums);
        binaryTree.traversal(binaryTree.getRoot());

    }

    private Node root;

    public BinaryTree(E[] nums) {
        root = new Node();
        buildTree(nums, root, 0);
    }

    public Node getRoot() {
        return root;
    }

    //后序遍历
    public void traversal(Node node) {
        if (node == null) {
            return;
        }
        traversal(node.left);
        traversal(node.right);
        System.out.println(node);
    }

    private void buildTree(E[] nums, Node node, int index) {
        node.value = nums[index];
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < nums.length) {
            node.left = new Node();
            node.left.parent = node;
            buildTree(nums, node.left, left);
        }
        if (right < nums.length) {
            node.right = new Node();
            node.right.parent = node;
            buildTree(nums, node.right, right);
        }
    }

    public void add() {
    }


    private class Node {
        private E value;

        private Node parent;
        private Node left;
        private Node right;

        private Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}

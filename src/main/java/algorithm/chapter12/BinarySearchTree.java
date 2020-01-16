package algorithm.chapter12;

/**
 * @Author long
 * @Date 21:56 2019/11/2
 * @Title
 * @Description 二叉搜索树
 **/

public class BinarySearchTree {

    private int size = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{12, 5, 18, 2, 9, 15, 19, 13, 17, 4, 7};
        BinarySearchTree tree = new BinarySearchTree(nums);
        tree.print();
        tree.delete(new int[]{12});
        Node successor = tree.successor(2);
        tree.print();
        System.out.println(successor);
        System.out.println(tree.getSize());
    }

    private Node root = null;

    public BinarySearchTree(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        buildBinarySearchTree(nums);
    }

    public int getSize() {
        return size;
    }

    public Node getRoot() {
        return root;
    }

    //先序遍历
    public void traversal(Node node) {
        if (node == null) {
            return;
        }
        traversal(node.left);
        System.out.print(node.value + " ");
        traversal(node.right);
    }

    public void print() {
        traversal(root);
        System.out.println();
    }

    private void buildBinarySearchTree(int[] nums) {
        for (int i : nums) {
            insert(i);
        }
    }

    public void insert(int e) {
        Node node = root;
        Node temp = null;
        while (node != null) {
            temp = node;
            if (e < node.value) {
                node = node.left;
            } else if (e > node.value) {
                node = node.right;
            } else {
                return;
            }
        }
        if (temp == null) {
            root = new Node(e);
        } else if (e < temp.value) {
            temp.left = new Node(e);
        } else {
            temp.right = new Node(e);
        }
        size++;
    }

    public Node search(int e) {
        Node node = root;
        while (node != null && node.value != e) {
            if (node.value < e) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }

    public void delete(int[] nums) {
        for (int i : nums) {
            delete(i);
        }
    }

    public void delete(int e) {
        Node parent = null;
        Node node = root;
        while (node != null && node.value != e) {
            parent = node;
            if (e > node.value) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (node == null) return;
        if (node.left == null) {
            transplant(parent, node, node.right);
        } else if (node.right == null) {
            transplant(parent, node, node.left);
        } else {
            Node subParent = node;
            Node right = node.right;
            while (right.left != null) {
                subParent = right;
                right = right.left;
            }
            if (subParent == node) {
                transplant(parent, node, node.right);
            }
            transplant(subParent, right, right.right);
            transplant(parent, node, right);
            right.left = node.left;
            right.right = node.right;
            node.right = node.left = null;
            node = null;
        }
        size--;
    }

    private void transplant(Node parent, Node u, Node v) {
        if (parent == null) {
            root = v;
        } else if (u == parent.left) {
            parent.left = v;
        } else if (u == parent.right) {
            parent.right = v;
        }
    }

    public int minimum() {
        Node temp = root;
        while (root.left != null) {
            temp = temp.left;
        }
        return temp.value;
    }

    public int maximum() {
        Node temp = root;
        while (root.right != null) {
            temp = temp.right;
        }
        return temp.value;
    }

    private Node getMaximum(Node node) {
        while (node != null && node.right != null) {
            node = node.right;
        }
        return node;
    }

    private Node getMinimum(Node node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node successor(int x) {
        return successor(root, x);
    }

    private Node successor(Node node, int x) {
        if (node == null) return null;
        Node successorNode = successor(node.left, x);
        if (successorNode != null) {
            if (successorNode.value == x) {
                return node;
            } else {
                return successorNode;
            }
        }
        if (node.value == x) {
            if (node.right != null) {
                return getMinimum(node.right);
            }
            return node;
        }
        return successor(node.right, x);
    }


    private class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int e) {
            value = e;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public Integer getSuccessor(Node node, Integer x) {
        if (node == null) return null;
        Integer y = getSuccessor(node.left, x);
        if (y != null) {
            if (x.equals(y)) {
                return node.value;
            } else {
                return y;
            }
        }
        if (node.value == x) {
            if (node.right != null) {
                return getMinimum(node.right).value;
            }
            return x;
        }
        return getSuccessor(node.right, x);
    }
}

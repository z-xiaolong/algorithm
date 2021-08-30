package dataStructure;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/4/9 10:33
 * @Title
 * @Description //TODO
 **/

public class AVLTree<T extends Comparable<T>> {

    private static int arr[] = {3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};

    public static void main(String[] args) {
        int i;
        AVLTree<Integer> tree = new AVLTree<>();
        System.out.println("== 依次添加: ");
        for (i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }
        tree.inorderTraversal();
        tree.postorderTraversal();
        tree.preorderTraversal();
        System.out.println();
        System.out.println("== 高度:" + tree.height());
        System.out.println("== 树的详细信息:");
        tree.print();

        i = 13;
        System.out.printf("\n== 删除根节点: %d", i);
        tree.remove(i);
        System.out.printf("\n== 高度: %d", tree.height());
        System.out.printf("\n== 树的详细信息: \n");
        tree.print();
        tree.remove(10);
        tree.print();
    }

    private TreeNode<T> root;

    public AVLTree() {
    }

    public AVLTree(T[] array) {
        for (T t : array) {
            this.insert(t);
        }
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    private int height(TreeNode<T> node) {
        if (node != null) return node.height;
        return 0;
    }

    public int height() {
        return height(root);
    }


    /*
     * 将结点插入到AVL树中，并返回根节点
     * 参数说明：
     *     node AVL树的结点
     *     value 插入结点的值
     * 返回值：插入节点
     */
    private TreeNode<T> insert(TreeNode<T> node, T value) {
        if (node == null) {
            //插入节点为null时，新建节点
            node = new TreeNode<>(value);
        } else {
            int cmp = value.compareTo(node.value);
            // 应该将key插入到" tree的左子树" 的情况
            if (cmp < 0) {
                node.left = insert(node.left, value);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(node.left) - height(node.right) == 2) {
                    if (value.compareTo(node.left.value) < 0)
                        node = leftLeftRotation(node);
                    else
                        node = leftRightRotation(node);
                }
            }
            //应该将key插入到"tree的右子树"的情况
            else if (cmp > 0) {
                node.right = insert(node.right, value);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(node.right) - height(node.left) == 2) {
                    if (value.compareTo(node.right.value) > 0)
                        node = rightRightRotation(node);
                    else
                        node = rightLeftRotation(node);
                }
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    /*
     * 递归查找树中是否存在目标值的节点
     * 参数说明：
     *     node 当前查找子树的根节点
     *     key 需要查找的结点值
     * 返回值：节点存在就返回该节点，否则返回 null
     */
    private TreeNode<T> search(TreeNode<T> node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.value);
        if (cmp < 0)
            return search(node.left, key);
        else if (cmp > 0)
            return search(node.right, key);
        else
            return node;
    }

    //非递归查找目标节点
    private TreeNode<T> iterativeSearch(TreeNode<T> node, T key) {
        while (node != null) {
            int cmp = key.compareTo(node.value);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node;
        }
        return null;
    }


    public void remove(T key) {
        root = remove(root, key);
    }

    /*
     * 删除结点(z)，返回根节点
     *
     * 参数说明：
     *     tree AVL树的根结点
     *      待删除的结点
     * 返回值：
     *     根节点
     */
    private TreeNode<T> remove(TreeNode<T> tree, T value) {
        //子树根节点为null，直接返回null。
        if (tree == null) return null;
        int cmp = tree.value.compareTo(value);
        // 待删除的节点在"tree的左子树"中
        if (cmp > 0) {
            tree.left = remove(tree.left, value);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.right) - height(tree.left) == 2) {
                TreeNode<T> right = tree.right;
                if (height(right.left) > height(right.right))
                    tree = rightLeftRotation(tree);
                else
                    tree = rightRightRotation(tree);
            }
        }
        // 待删除的节点在"tree的右子树"中
        else if (cmp < 0) {
            tree.right = remove(tree.right, value);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.left) - height(tree.right) == 2) {
                TreeNode<T> left = tree.left;
                if (height(left.right) > height(left.left))
                    tree = leftRightRotation(tree);
                else
                    tree = leftLeftRotation(tree);
            }
        }
        // tree是对应要删除的节点。
        else {
            // tree的左右孩子都非空
            if ((tree.left != null) && (tree.right != null)) {
                if (height(tree.left) > height(tree.right)) {
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的前驱节点
                    //   (02)将该前驱节点的值赋值给tree。
                    //   (03)递归删除该前驱节点。
                    // 删除"tree的前驱节点"之后，不需要考虑tree节点左右子树的平衡性问题。
                    TreeNode<T> predecessor = predecessor(tree);
                    tree.value = predecessor.value;
                    tree.left = remove(tree.left, predecessor.value);
                } else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的后继节点
                    //   (02)将该后继节点的值赋值给tree。
                    //   (03)递归删除该后继节点。
                    // 删除"tree的后继节点"之后，不需要考虑tree节点左右子树的平衡性问题。
                    TreeNode<T> successor = successor(tree);
                    tree.value = successor.value;
                    tree.right = remove(tree.right, successor.value);
                }
            } else {
                tree = (tree.left != null) ? tree.left : tree.right;
                return tree;
            }
        }
        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    //节点右子树不为 null 时，得到节点的后继节点
    private TreeNode<T> successor(@NotNull TreeNode<T> node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //节点左子树不为 null 时，得到节点的前驱节点
    private TreeNode<T> predecessor(@NotNull TreeNode<T> node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private List<T> preorderTraversal(TreeNode<T> root) {
        List<T> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            list.add(node.value);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }

    public void preorderTraversal() {
        List<T> list = preorderTraversal(root);
        System.out.println();
        System.out.print("先序遍历：");
        for (T t : list) {
            System.out.print(t + " ");
        }
    }

    //层序遍历
    public void levelOrderTraversal() {
        List<T> list = levelOrderTraversal(root);
        for (T t : list) {
            System.out.print(t + " ");
        }
    }

    public boolean isCompleteTree() {
        if (root == null) return true;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode<T> node = queue.poll();
                assert node != null;
                if (!flag && node.left != null) return false;
                if (node.left != null) queue.add(node.left);
                else flag = false;
                if (!flag && node.right != null) return false;
                if (node.right != null) queue.add(node.right);
                else flag = false;
                size--;
            }
        }
        return true;
    }

    public List<T> levelOrderTraversal(TreeNode<T> root) {
        List<T> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode<T> node = queue.poll();
                list.add(node.value);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
        }
        return list;
    }


    //中序迭代遍历
    private List<T> inorderTraversal(TreeNode<T> root) {
        List<T> list = new LinkedList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode<T> node = stack.pop();
                list.add(node.value);
                root = node.right;
            }
        }
        return list;
    }

    public void inorderTraversal() {
        List<T> list = inorderTraversal(root);
        System.out.println();
        System.out.print("中序遍历：");
        for (T t : list) {
            System.out.print(t + " ");
        }
    }

    //后序迭代遍历
    private List<T> postorderTraversal(TreeNode<T> root) {
        LinkedList<T> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            list.addFirst(node.value);
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        return list;
    }

    public void postorderTraversal() {
        List<T> list = postorderTraversal(root);
        System.out.println();
        System.out.print("后序遍历：");
        for (T t : list) {
            System.out.print(t + " ");
        }
    }

    /*
     * LL：左左对应的情况(左单旋转)。
     * 返回值：旋转后的根节点
     */
    private TreeNode<T> leftLeftRotation(TreeNode<T> N1) {
        TreeNode<T> N2 = N1.left;
        N1.left = N2.right;
        N2.right = N1;

        N2.height = Math.max(height(N2.left), N1.height) + 1;
        N1.height = Math.max(height(N1.left), height(N1.right)) + 1;
        return N2;
    }

    /*
     * RR：右右对应的情况(右单旋转)。
     * 返回值：旋转后的根节点
     */
    private TreeNode<T> rightRightRotation(TreeNode<T> N1) {
        TreeNode<T> N2 = N1.right;
        N1.right = N2.left;
        N2.left = N1;

        N1.height = Math.max(height(N1.left), height(N1.right)) + 1;
        N2.height = Math.max(height(N2.right), N1.height) + 1;
        return N2;
    }

    /*
     * LR：左右对应的情况(左双旋转)。
     * 返回值：旋转后的根节点
     */
    private TreeNode<T> leftRightRotation(TreeNode<T> N1) {
        N1.left = rightRightRotation(N1.left);
        return leftLeftRotation(N1);
    }

    /*
     * RL：右左对应的情况(右双旋转)。
     * 返回值：旋转后的根节点
     */
    private TreeNode<T> rightLeftRotation(TreeNode<T> N1) {
        N1.right = leftLeftRotation(N1.right);
        return rightRightRotation(N1);
    }

    public void print() {
        TreeNode<T> node = root;
        int height = root.height;
        int length = 1 << (height + 1);
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(node);
        while (height > 0) {
            int size = queue.size();
            int several = length / (size + 1);
            System.out.print("");
            while (size > 0) {
                TreeNode<T> temp = queue.poll();
                //printSpace(several);
                if (temp != null) {
                    System.out.printf("%" + several + "d", temp.value);
                    queue.add(temp.left);
                    queue.add(temp.right);
                } else {
                    System.out.printf("%" + several + "s", "*");
                    queue.add(null);
                    queue.add(null);
                }
                size--;
            }
            System.out.println();
            height--;
        }
    }

    static class TreeNode<T extends Comparable<T>> {

        public int height;
        public T value;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T value) {
            this.value = value;
        }

        public TreeNode(T value, int height, TreeNode<T> left, TreeNode<T> right) {
            this.value = value;
            this.height = height;
            this.left = left;
            this.right = right;
        }
    }
}



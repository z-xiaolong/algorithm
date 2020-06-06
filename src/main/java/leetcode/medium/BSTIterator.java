package leetcode.medium;

import algorithm.chapter10.MyStack;
import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/4/7 17:48
 * @Title 173. 二叉搜索树迭代器
 * @Description //TODO
 **/

public class BSTIterator {

    private MyStack<TreeNode> myStack;

    public BSTIterator(TreeNode root) {
        this.myStack = new MyStack<>();
        while (root != null) {
            myStack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = myStack.pop();
        if (node.right != null) {
            TreeNode temp = node.right;
            while (temp != null) {
                myStack.push(temp);
                temp = temp.left;
            }
        }
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !myStack.isEmpty();
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        insert(root, val);
        return root;
    }

    public void insert(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left == null) node.left = new TreeNode(val);
            else insert(node.left, val);
        }
        if (node.val < val) {
            if (node.right == null) node.right = new TreeNode(val);
            else insert(node.right, val);
        }
    }
}

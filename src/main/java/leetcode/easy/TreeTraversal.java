package leetcode.easy;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/4/7 15:36
 * @Title 二叉树的遍历
 * @Description //TODO
 **/

public class TreeTraversal {

    //后序迭代遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        return list;
    }

    public void postorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        postorderTraversal(node.left, list);
        postorderTraversal(node.right, list);
        list.add(node.val);
    }

    //先序遍历，迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }

    public void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }

    //中序迭代遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list;
    }

    public void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }


}

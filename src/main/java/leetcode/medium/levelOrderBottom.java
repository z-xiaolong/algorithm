package leetcode.medium;

import leetcode.entity.TreeNode;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/4 15:53
 * @Title 107. 二叉树的层次遍历 II
 * @Description 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 **/

public class levelOrderBottom {

    //递归
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        recursion(result, root, 1);
        return result;
    }

    public void recursion(LinkedList<List<Integer>> result, TreeNode node, int level) {
        List<Integer> list;
        if (level > result.size()) {
            list = new LinkedList<>();
            result.addFirst(list);
        }
        list = result.get(result.size() - level);
        list.add(node.val);
        if (node.left != null) {
            recursion(result, node.left, level + 1);
        }
        if (node.right != null) {
            recursion(result, node.right, level + 1);
        }
    }

    //广度优先遍历，链表实现
    public List<List<Integer>> levelOrderBottomII(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.addFirst(list);
        }
        return result;
    }

    //广度优先遍历，结合堆栈，反转
    public List<List<Integer>> levelOrderBottomI(TreeNode root) {
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            stack.push(new ArrayList<>(list));
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }
}

package leetcode.swordOffer.medium;

import leetcode.entity.TreeNode;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/12 16:14
 * @Title 面试题32 - III. 从上到下打印二叉树 III
 * @Description 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 **/

public class LevelOrder {

    //执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public List<List<Integer>> levelOrderIII(TreeNode root) {
        List<List<Integer>> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (flag) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            output.add(list);
            flag = !flag;
        }
        return output;
    }


    //
    public int[] levelOrderI(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    //面试题32 - II. 从上到下打印二叉树 II
    //执行用时 :1 ms, 在所有 Java 提交中击败了95.80%的用户
    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            res.add(list);
        }
        return res;
    }

}

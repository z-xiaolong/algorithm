package leetcode.medium;

import leetcode.entity.ListNode;
import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/2/29 18:08
 * @Title 102. 二叉树的层次遍历
 * @Description 给定一个二叉树，返回其按层次遍历的节点值。
 * （即逐层地，从左到右访问所有节点）。
 **/

public class LevelOrder {

    //广度优先遍历,改进后：执行用时 :1 ms, 在所有 Java 提交中击败了97.10%的用户
    public List<List<Integer>> levelOrder(TreeNode root) {
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
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    //广度优先遍历
    public List<List<Integer>> levelOrderI(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.add(root);
        int nodeNum = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            nodeNum--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (nodeNum == 0) { //当前层遍历完
                result.add(new ArrayList<>(list));
                list.clear();
                nodeNum = queue.size();
            }
        }
        return result;
    }

    public void breadth(TreeNode node) {

    }

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int count = 0;
        for (int i = 0; i < T.length; i++) {
            int k = i + 1;
            count = 0;
            while (k < T.length && T[i] > T[k]) {
                k++;
                count++;
            }
            if (k != T.length) {
                res[i] = count;
            }
        }
        return res;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }


}

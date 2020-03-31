package leetcode.easy.bfs;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/3/9 17:24
 * @Title 111. 二叉树的最小深度
 * @Description 给定一个二叉树，找出其最小深度。
 **/

public class MinDepth {

    //BFS ：执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.right == null && node.left == null) {
                    return res;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }
        return res;
    }

    //DFS: 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int minDepthI(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    public int dfs(TreeNode node) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (node.left != null) {
            left = dfs(node.left);
        }
        if (node.right != null) {
            right = dfs(node.right);
        }
        if (node.right == null && node.left == null) {
            return 1;
        }
        return Math.min(left, right) + 1;
    }
}

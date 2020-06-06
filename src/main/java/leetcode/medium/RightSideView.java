package leetcode.medium;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/4/22 9:39
 * @Title 199. 二叉树的右视图
 * @Description //TODO
 **/

public class RightSideView {


    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(res, root, 0);
            return res;
        }

        private void dfs(List<Integer> res, TreeNode node, int level) {
            if (node != null) {
                //***特别优秀的一步操作：判断是否为每一层的第一个元素***
                if (res.size() == level) {
                    res.add(node.val);
                }
                dfs(res, node.right, level + 1);
                dfs(res, node.left, level + 1);
            }
        }
    }

    //BFS：执行用时 :1 ms, 在所有 Java 提交中击败了97.39%的用户
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new LinkedList<>();
        if (root == null) return output;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 1) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            TreeNode node = queue.poll();
            output.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return output;
    }
}

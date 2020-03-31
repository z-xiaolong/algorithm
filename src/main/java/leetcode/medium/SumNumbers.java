package leetcode.medium;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/3/10 10:21
 * @Title 129. 求根到叶子节点数字之和
 * @Description 给定一个二叉树，
 * 它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 **/

public class SumNumbers {

    private int sum = 0;

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root, 0);
        return sum;
    }

    public void depth(TreeNode node, int value) {
        int subSum = value * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += subSum;
            return;
        }
        if (node.left != null) {
            depth(node.left, subSum);
        }
        if (node.right != null) {
            depth(node.right, subSum);
        }
    }
}

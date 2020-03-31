package leetcode.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 22:19 2019/11/9
 * @Title 543. 二叉树的直径
 * @Description 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 **/

public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root);
        return diameter - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        if (left + right + 1 > diameter) {
            diameter = left + right + 1;
        }
        return left >= right ? left + 1 : right + 1;
    }
}

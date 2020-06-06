package leetcode.hard;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/4/20 11:08
 * @Title 124. 二叉树中的最大路径和
 * @Description //TODO
 **/

public class MaxPathSum {

    private int max = Integer.MIN_VALUE;

    //执行用时 :1 ms, 在所有 Java 提交中击败了99.79%的用户
    public int maxPathSum(TreeNode root) {
        inorder(root);
        return max;
    }

    public int inorder(TreeNode node) {
        if (node == null) return 0;
        int left = inorder(node.left);
        int right = inorder(node.right);
        int subMax = node.val;
        if (left > 0) subMax += left;
        if (right > 0) subMax += right;
        max = Math.max(max, subMax);
        return node.val + Math.max(0, Math.max(left, right));
    }
}

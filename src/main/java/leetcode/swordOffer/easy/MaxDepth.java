package leetcode.swordOffer.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/3/5 21:59
 * @Title 面试题55 - I. 二叉树的深度
 * @Description //TODO
 **/

public class MaxDepth {

    //深度优先
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

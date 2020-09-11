package leetcode.hard;

import leetcode.entity.TreeNode;

/**
 * @Author: long
 * @Date: 2020/8/8 9:15
 * @Title 99. 恢复二叉搜索树
 * @Description:
 */
public class RecoverTree {

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode predecessor = null;

    }

    public TreeNode predecessor(TreeNode node) {
        TreeNode predecessor = node.left;
        while (predecessor.right != null && predecessor.right != node) {
            predecessor = predecessor.right;
        }
        return predecessor;
    }
}

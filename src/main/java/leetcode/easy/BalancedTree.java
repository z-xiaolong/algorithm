package leetcode.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2019/10/4 15:51
 */

/*给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
百度定义：一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。*/
public class BalancedTree {


    //首先判断子树是否为平衡二叉树,自底向上
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }


    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(node.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


}

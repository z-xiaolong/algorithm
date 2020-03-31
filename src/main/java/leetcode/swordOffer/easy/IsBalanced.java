package leetcode.swordOffer.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/3/13 11:24
 * @Title 面试题55 - II. 平衡二叉树
 * @Description 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 **/

public class IsBalanced {

    //执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        depth(root);
        return check(root);
    }

    public boolean check(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        } else if (node.left == null) {
            return node.right.val < 2;
        } else if (node.right == null) {
            return node.left.val < 2;
        } else {
            if (Math.abs(node.left.val - node.right.val) >= 2) {
                return false;
            } else {
                return check(node.left) && check(node.right);
            }
        }
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        node.val = Math.max(depth(node.left), depth(node.right)) + 1;
        return node.val;
    }
}

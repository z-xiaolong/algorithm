package leetcode.swordOffer.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/3/8 20:05
 * @Title 面试题27. 二叉树的镜像
 * @Description //TODO
 **/

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        recursion(root);
        return root;
    }

    public void recursion(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        recursion(node.right);
        recursion(node.left);
    }
}

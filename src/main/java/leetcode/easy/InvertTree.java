package leetcode.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 11:15 2019/10/31
 * @Title 226. 翻转二叉树
 * @Description 翻转一棵二叉树。
 **/

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

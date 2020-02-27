package leetcode.medium;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/2/9 15:49
 * @Title
 * @Description 给定一个二叉树，原地将它展开为链表。
 **/

public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        recursion(root);
    }

    public TreeNode recursion(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = recursion(node.left);
        TreeNode right = recursion(node.right);
        if(left != null && right != null){
            left.right = node.right;
            node.right = node.left;
            node.left = null;
            return right;
        }
        else if(left != null){
            node.right = node.left;
            node.left = null;
            return left;
        }
        else if(right == null){
            return node;
        }
        else{
            return right;
        }
    }
}

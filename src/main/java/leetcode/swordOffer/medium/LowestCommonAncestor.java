package leetcode.swordOffer.medium;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/3/13 15:36
 * @Title 面试题68 - II. 二叉树的最近公共祖先
 * @Description 此题为二叉树，上题为二叉搜索树
 **/

public class LowestCommonAncestor {


    //执行用时 :8 ms, 在所有 Java 提交中击败了99.84%的用户
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val == root.val || q.val == root.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}

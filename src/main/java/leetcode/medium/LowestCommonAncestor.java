package leetcode.medium;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/5/10 9:44
 * @Title 二叉树的最近公共祖先
 * @Description //TODO
 **/

public class LowestCommonAncestor {


    //执行用时 :7 ms, 在所有 Java 提交中击败了99.87%的用户
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}

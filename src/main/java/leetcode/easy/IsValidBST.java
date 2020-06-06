package leetcode.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/4/7 16:54
 * @Title 98. 验证二叉搜索树
 * @Description //TODO
 **/

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return verify(root, null, null);
    }

    //lower: 当前节点需要满足的下界，upper: 当前节点需要满足的上界
    public boolean verify(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        int val = node.val;
        if (lower != null && val <= lower) return false; //小于下界，返回false
        if (upper != null && val >= upper) return false; //大于上届，返回false

        if (!verify(node.left, lower, val)) return false; //验证左子树
        if (!verify(node.right, val, upper)) return false; //验证右子树
        return true;
    }


    public boolean isValidBSTI(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            if (root.val <= root.left.val) return false;
            if (!isValidBSTI(root.left)) return false;
            if (root.val <= getMax(root.left)) return false;
        }
        if (root.right != null) {
            if (root.val >= root.right.val) return false;
            if (!isValidBSTI(root.right)) return false;
            if (root.val >= getMin(root.right)) return false;
        }
        return true;
    }

    public int getMax(TreeNode node) {
        if (node.right != null) return getMax(node.right);
        return node.val;
    }

    public int getMin(TreeNode node) {
        if (node.left != null) return getMin(node.left);
        return node.val;
    }
}

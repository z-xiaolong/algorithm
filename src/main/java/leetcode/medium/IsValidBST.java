package leetcode.medium;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/5/5 14:38
 * @Title
 * @Description //TODO
 **/

public class IsValidBST {

    long preNode = Long.MIN_VALUE;

    //中序遍历二叉树，记录前驱节点的值，只需与前驱节点比较
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= preNode) return false;
        preNode = root.val;
        if (!isValidBST(root.right)) return false;
        return true;
    }
}

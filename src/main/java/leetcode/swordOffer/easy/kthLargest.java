package leetcode.swordOffer.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/3/9 11:07
 * @Title 面试题54. 二叉搜索树的第k大节点
 * @Description 给定一棵二叉搜索树，请找出其中第k大的节点。
 **/

public class kthLargest {

    private int Kth = 0;
    private int index = 0;

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int kthLargest(TreeNode root, int k) {
        count(root, k);
        return Kth;
    }

    public boolean count(TreeNode node, int k) {
        if (node == null) {
            return false;
        }
        boolean res = count(node.right, k);
        index++;
        if (index == k) {
            Kth = node.val;
            return true;
        }
        return res || count(node.left, k);
    }
}

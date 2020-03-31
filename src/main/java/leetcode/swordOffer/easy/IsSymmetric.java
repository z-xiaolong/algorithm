package leetcode.swordOffer.easy;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/3/13 10:32
 * @Title 面试题28. 对称的二叉树
 * @Description 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 **/

public class IsSymmetric {

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }


    //节点值可以一样，不能通过全部测试用例
    public boolean isSymmetricI(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> listRight = new LinkedList<>();
        List<Integer> listLeft = new LinkedList<>();
        dfsLeft(root.left, listLeft);
        dfsRight(root.right, listRight);
        if (listLeft.size() != listRight.size()) {
            return false;
        }
        for (int i = 0; i < listLeft.size(); i++) {
            if (listLeft.get(i) != listRight.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void dfsLeft(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfsLeft(node.left, list);
        list.add(node.val);
        dfsLeft(node.right, list);
    }

    public void dfsRight(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfsRight(node.right, list);
        list.add(node.val);
        dfsRight(node.left, list);
    }
}

package leetcode.swordOffer.medium;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/3/25 10:39
 * @Title 面试题26. 树的子结构
 * @Description //TODO
 **/

public class IsSubStructure {


    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return (A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right))
                || isSubStructure(A.left, B)
                || isSubStructure(A.right, B);
    }

    public boolean recur(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null || node1.val != node2.val) {
            return false;
        }
        return recur(node1.left, node2.left) && recur(node1.right, node2.right);
    }

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public boolean isSubStructureI(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val) {
            boolean res = true;
            if (B.left != null) {
                res = checkSub(A.left, B.left);
            }
            if (B.right != null) {
                res = res && checkSub(A.right, B.right);
            }
            if (res) {
                return true;
            }
        }
        return isSubStructureI(A.left, B) || isSubStructureI(A.right, B);
    }

    public boolean checkSub(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        boolean res = true;
        if (node2.left != null) {
            res = checkSub(node1.left, node2.left);
        }
        if (node2.right != null) {
            res = res && checkSub(node1.right, node2.right);
        }
        return res;
    }

    public boolean recursion(TreeNode node, TreeNode target) {
        if (node == null || target == null) {
            return false;
        }
        if (node.val == target.val) {
            boolean res = true;
            if (target.left != null) {
                res = recursion(node.left, target.left);
            }
            if (target.right != null) {
                res = res && recursion(node.right, target.right);
            }
            if (res) {
                return true;
            }
        }
        return recursion(node.left, target) || recursion(node.right, target);
    }
}

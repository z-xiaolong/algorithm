package leetcode.swordOffer.easy;

import leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/3/13 14:14
 * @Title 面试题68 - I. 二叉搜索树的最近公共祖先
 * @Description 所有节点的值都是唯一的。
 **/

public class LowestCommonAncestor {


    //非递归: 执行用时 :6 ms, 在所有 Java 提交中击败了99.82%的用户
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    //考虑二叉搜索树，递归： 执行用时 :6 ms, 在所有 Java 提交中击败了99.82%的用户
    public TreeNode lowestCommonAncestorIII(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorIII(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorIII(root.left, p, q);
        }
        return root;
    }


    //未考虑是二叉搜索树：执行用时 :7 ms, 在所有 Java 提交中击败了72.05%的用户
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        return lowest(root, p, q);
    }

    public TreeNode lowest(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }
        if (p.val == node.val || q.val == node.val) {
            return node;
        }
        TreeNode left = lowest(node.left, p, q);
        TreeNode right = lowest(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    //执行用时 :12 ms, 在所有 Java 提交中击败了6.85%的用户
    public TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = depth(root, p);
        Stack<TreeNode> qStack = depth(root, q);
        TreeNode res = root;
        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode pNode = pStack.pop();
            TreeNode qNode = qStack.pop();
            if (pNode.val == qNode.val) {
                res = pNode;
            } else {
                break;
            }
        }
        return res;
    }

    public Stack<TreeNode> depth(TreeNode node, TreeNode target) {
        if (node == null) {
            return null;
        }
        Stack<TreeNode> stack;
        if (node.val == target.val) {
            stack = new Stack<>();
            stack.push(node);
            return stack;
        }
        stack = depth(node.left, target);
        if (stack != null) {
            stack.push(node);
            return stack;
        }
        stack = depth(node.right, target);
        if (stack == null) {
            return null;
        }
        stack.push(node);
        return stack;
    }
}

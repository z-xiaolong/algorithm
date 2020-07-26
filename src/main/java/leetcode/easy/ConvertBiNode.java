package leetcode.easy;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/7/22 14:12
 * @Title
 * @Description //TODO
 **/

public class ConvertBiNode {


    public TreeNode convertBiNodeI(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = new TreeNode(0);
        TreeNode temp = head;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                temp.right = node;
                temp.left = null;
                temp = temp.right;
                node = node.right;
            }
        }
        return head.right;
    }

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(0);
        inorder(root, head);
        return head.right;
    }

    public TreeNode inorder(TreeNode node, TreeNode prev) {
        if (node != null) {
            prev = inorder(node.left, prev);
            prev.right = node;
            node.left = null;
            prev = inorder(node.right, node);
        }
        return prev;
    }

}

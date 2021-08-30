package leetcode.easy;

import leetcode.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author long
 * @Date 2021/3/28 10:13
 * @Title
 * @Description //TODO
 **/

class BSTIterator {

    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode right = node.right;
        while (right != null) {
            stack.push(right);
            right = right.left;
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

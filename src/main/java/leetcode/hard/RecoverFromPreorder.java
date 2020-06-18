package leetcode.hard;

import leetcode.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/6/18 9:38
 * @Title
 * @Description //TODO
 **/

public class RecoverFromPreorder {

    public static void main(String[] args) {
        RecoverFromPreorder preorder = new RecoverFromPreorder();
        preorder.recoverFromPreorder("1-2--3--4-5--6--7");
    }


    //迭代
    public TreeNode recoverFromPreorder(String S) {
        if (S.length() == 0) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        int index = 0;
        while (index < S.length()) {
            int level = 0;
            int value = 0;
            while (index < S.length() && S.charAt(index) == '-') {
                index++;
                level++;
            }
            while (index < S.length() && S.charAt(index) != '-') {
                value = value * 10 + S.charAt(index) - '0';
                index++;
            }
            TreeNode node = new TreeNode(value);
            while (stack.size() > level) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(node);
                continue;
            }
            if (stack.peek().left == null)
                stack.peek().left = node;
            else
                stack.peek().right = node;
            stack.push(node);
        }
        while (stack.size() > 1) stack.pop();
        return stack.peek();
    }

    int index;
    int level;

    //强行递归
    public TreeNode recoverFromPreorderI(String S) {
        if (S.length() == 0) return null;
        index = 0;
        level = 0;
        int value = 0;
        char c;
        while (index < S.length() && (c = S.charAt(index)) != '-') {
            value = value * 10 + c - '0';
            index++;
        }
        TreeNode root = new TreeNode(value);
        root.left = dfs(S);
        root.right = dfs(S);
        return root;
    }


    public TreeNode dfs(String str) {
        if (index >= str.length()) return null;
        char c;
        int value = 0;
        int curLevel = 0;
        int curIndex = index;
        while (str.charAt(curIndex) == '-') {
            curIndex++;
            curLevel++;
        }
        if (curLevel <= level) return null;
        while (curIndex < str.length() && (c = str.charAt(curIndex)) != '-') {
            value = value * 10 + c - '0';
            curIndex++;
        }
        TreeNode node = new TreeNode(value);
        index = curIndex;
        int temp = level;
        level = curLevel;
        node.left = dfs(str);
        node.right = dfs(str);
        level = temp;
        return node;
    }
}

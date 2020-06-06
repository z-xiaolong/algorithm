package leetcode.hard;

import leetcode.entity.TreeNode;

import java.util.*;

/**
 * @Author long
 * @Date 2020/5/30 11:30
 * @Title 316. 去除重复字母
 * @Description //TODO
 **/

public class RemoveDuplicateLetters {


    public String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        int[] map = new int[26];
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                while (!stack.empty() && c < stack.peek() && map[stack.peek() - 'a'] > i) {
                    set.remove(stack.pop());
                }
                stack.push(c);
                set.add(c);
            }
        }
        for (Character c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.right, right.left) && check(left.left, right.right);
    }
}

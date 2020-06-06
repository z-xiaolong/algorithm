package leetcode.swordOffer.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/4/2 11:44
 * @Title 面试题19. 正则表达式匹配
 * @Description //TODO
 **/

public class IsMatch {

    public static void main(String[] args) {
        IsMatch match = new IsMatch();
        match.isMatch("aab", "c*a*b");
    }

    //带备忘录的动态规划：执行用时 :2 ms, 在所有 Java 提交中击败了99.98%的用户
    int[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];
        return dp(s, p, 0, 0);
    }

    public boolean dp(String s, String p, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        if (i >= s.length()) {
            if (j >= p.length()) {
                dp[i][j] = 1;
                return true;
            } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                if (dp(s, p, i, j + 2)) {
                    dp[i][j] = 1;
                    return true;
                } else {
                    dp[i][j] = -1;
                    return false;
                }
            } else {
                dp[i][j] = -1;
                return false;
            }
        }
        boolean res = false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                res = dp(s, p, i + 1, j);
            }
            res = res || dp(s, p, i, j + 2);
        } else if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            res = dp(s, p, i + 1, j + 1);
        }
        if (res) dp[i][j] = 1;
        else dp[i][j] = -1;
        return res;
    }

    //回溯：执行用时 :40 ms, 在所有 Java 提交中击败了42.14%的用户
    public boolean isMatchII(String s, String p) {
        return backtrack(s, p, 0, 0);
    }

    public boolean backtrack(String s, String p, int i, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        } else if (i < s.length() && j >= p.length()) {
            return false;
        }
        boolean res = false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                res = backtrack(s, p, i + 1, j);
            }
            res = res || backtrack(s, p, i, j + 2);
        } else if (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
            res = backtrack(s, p, i + 1, j + 1);
        }
        return res;
    }


    //构造自动机：执行用时 :29 ms, 在所有 Java 提交中击败了44.31%的用户
    public boolean isMatchI(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        TreeNode root = buildTree(p, 0);
        return match(root, s, 0);
    }

    public boolean match(TreeNode node, String s, int index) {
        if (node == null) {
            return false;
        }
        if (index >= s.length()) {
            if (node.value == '$') {
                return match(node.right, s, index);
            }
            return node.value == '#';
        }
        char c = s.charAt(index);
        if (c == node.value || node.value == '.') {
            return match(node.right, s, index + 1);
        } else if (node.value == '$') {
            return match(node.right, s, index) || match(node.left, s, index);
        } else {
            return false;
        }
    }

    public TreeNode buildTree(String p, int index) {
        if (index >= p.length()) {
            return new TreeNode('#');
        }
        TreeNode cur = new TreeNode(p.charAt(index));
        if (index + 1 < p.length() && p.charAt(index + 1) == '*') {
            TreeNode nullNode = new TreeNode('$');
            nullNode.left = cur;
            cur.right = nullNode;
            nullNode.right = buildTree(p, index + 2);
            return nullNode;
        } else {
            cur.right = buildTree(p, index + 1);
        }
        return cur;
    }


    class TreeNode {
        char value;
        TreeNode left;
        TreeNode right;

        public TreeNode(char value) {
            this.value = value;
        }
    }
}

package leetcode.hard;

import algorithm.chapter10.MyStack;

/**
 * @Author long
 * @Date 2020/4/11 16:24
 * @Title 32. 最长有效括号
 * @Description //TODO
 **/

public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses parentheses = new LongestValidParentheses();
        parentheses.longestValidParentheses("(()");
    }


    //dp: 执行用时 :2 ms, 在所有 Java 提交中击败了91.92%的用户
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) dp[i] = dp[i - 2] + 2;
                    else dp[i] = 2;
                } else if (s.charAt(i - 1) == ')') {
                    int j = dp[i - 1];
                    if (i > j && s.charAt(i - j - 1) == '(') {
                        if (i >= j + 2) {
                            dp[i] = dp[i - 1] + dp[i - j - 2] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    //栈
    public int longestValidParenthesesI(String s) {
        MyStack<Character> myStack = new MyStack<>();
        int count = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                myStack.push(c);
            } else {
                if (myStack.isEmpty()) {
                    count = 0;
                } else {
                    myStack.pop();
                    count++;
                    max = Math.max(max, count);
                }
            }
        }
        return max * 2;
    }
}

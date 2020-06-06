package leetcode.medium;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/4/30 10:01
 * @Title 402. 移掉K位数字
 * @Description 单调栈的运用
 **/

public class RemoveKdigits {


    //优化后：执行用时 :7 ms, 在所有 Java 提交中击败了82.74%的用户
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (length == 0 || length == k) return "0";
        Stack<Character> stack = new Stack<>();  //构造单调栈
        int i = 0;
        while (i < length && k > 0) {
            char cur = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > cur) {
                stack.pop();
                k--;
            }
            if (!stack.isEmpty() || cur != '0') {
                stack.push(cur);
            }
            i++;
        }
        while (i < length) stack.push(num.charAt(i++));
        while (k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) return "0";
        char[] chars = new char[stack.size()];
        for (int j = chars.length - 1; j >= 0; j--) {
            chars[j] = stack.pop();
        }
        return String.valueOf(chars);
    }

    //执行用时 :9 ms, 在所有 Java 提交中击败了67.91%的用户
    public String removeKdigitsI(String num, int k) {
        int n = num.length();
        if (n == 0 || n == k) return "0";
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));
        int i = 1;
        while (i < n && k > 0) {
            char temp = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && temp < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(temp);
            i++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        while (i < n) {
            stack.push(num.charAt(i));
            i++;
        }
        while (stack.size() > 0) {
            builder.append(stack.pop());
        }
        String res = builder.reverse().toString();
        int j = 0;
        while (j < res.length() && res.charAt(j) == '0') {
            j++;
        }
        if (j == res.length()) return "0";
        return res.substring(j);
    }
}

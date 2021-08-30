package leetcode.hard;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/5/8 22:27
 * @Title 224. 基本计算器
 * @Description //TODO
 **/

public class Calculate {

    public int calculate(String s) {
        Stack<Integer> ops = new Stack<>();
        int i = 0;
        int length = s.length();
        int result = 0;
        int sign = 1;
        ops.push(sign);
        while (i < length) {
            if (s.charAt(i) == '(') {
                ops.push(sign);
            } else if (s.charAt(i) == ')') {
                ops.pop();
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
            } else if (s.charAt(i) != ' ') {
                long num = 0;
                while (i < length && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += sign * num;
                continue;
            }
            i++;
        }
        return result;
    }


    public int calculateII(String s) {
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        char sign = '+';
        int res = 0;
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!isDigit(c) && c != ' ' || i == len - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}

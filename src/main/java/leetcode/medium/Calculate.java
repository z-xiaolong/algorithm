package leetcode.medium;

import leetcode.entity.TreeNode;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/5/9 17:54
 * @Title 面试题 16.26. 计算器
 * @Description //TODO
 **/

public class Calculate {

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        int res = calculate.calculate("4+2  + 4 * 4 + 1 -1/2 +2 -1-2-14-3+211+2132/3");
        System.out.println(res);
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> numbers = new Stack<>();
        int i = 0;
        int length = s.length();
        while (i < length) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (i < length && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int num = Integer.parseInt(s.substring(j, i));
                numbers.push(num);
            } else if (c == '+' || c == '-') {
                i++;
                while (i < length && s.charAt(i) == ' ') {
                    i++;
                }
                int j = i;
                while (i < length && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int num = Integer.parseInt(s.substring(j, i));
                if (c == '-') num = -num;
                numbers.push(num);
            } else if (c == '*' || c == '/') {
                i++;
                while (i < length && s.charAt(i) == ' ') {
                    i++;
                }
                int j = i;
                while (i < length && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int a = Integer.parseInt(s.substring(j, i));
                int b = numbers.pop();
                numbers.push(calculate(c, b, a));
            } else {
                i++;
            }
        }
        int res = 0;
        while (!numbers.isEmpty()) {
            res += numbers.pop();
        }
        return res;
    }

    public int calculate(char op, int a, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }


    //简洁答案
    public int calculateI(String s) {
        int length = s.length();
        if (length == 0) return 0;
        Stack<Integer> numbers = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!isDigit(c) && c != ' ' || i == length - 1) {
                int preNum;
                switch (sign) {
                    case '+':
                        numbers.push(num);
                        break;
                    case '-':
                        numbers.push(-num);
                        break;
                    case '*':
                        preNum = numbers.pop();
                        numbers.push(preNum * num);
                        break;
                    case '/':
                        preNum = numbers.pop();
                        numbers.push(preNum / num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!numbers.isEmpty()) {
            res += numbers.pop();
        }
        return res;
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (left == null) return lowestCommonAncestor(root.right, p, q);
        if (left == p || left == q) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right == p || right == q) return root;
            if (right == null) return left;
            return right;
        }
        return left;
    }
}

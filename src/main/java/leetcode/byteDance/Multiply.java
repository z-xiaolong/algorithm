package leetcode.byteDance;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/6/18 11:34
 * @Title 字符串相乘
 * @Description //TODO
 **/

public class Multiply {

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply("12", "111"));
    }

    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int product = a * b + res[i + j + 1];
                res[i + j + 1] = product % 10;
                res[i + j] += product / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < res.length && res[index] == 0) index++;
        for (int i = index; i < res.length; i++) {
            builder.append(res[i]);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

    public String multiplyI(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return "0";
        Stack<String> stack = new Stack<>();
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int count = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int num = num2.charAt(i) - '0';
            StringBuilder p = product(num1, num);
            if (p.length() == 0) {
                p.append(0);
            } else {
                for (int j = 0; j < count; j++) {
                    p.append(0);
                }
            }
            stack.push(p.toString());
            count++;
        }
        String product = null;
        if (!stack.isEmpty()) {
            product = stack.pop();
        }
        while (!stack.isEmpty()) {
            product = add(product, stack.pop());
        }
        return product;
    }

    public StringBuilder product(String num, int multiplier) {
        StringBuilder builder = new StringBuilder();
        if (multiplier == 0) {
            return builder;
        }
        int index = num.length() - 1;
        int carry = 0;
        while (index >= 0) {
            int number = num.charAt(index--) - '0';
            int product = number * multiplier + carry;
            carry = product / 10;
            builder.append(product % 10);
        }
        if (carry > 0) builder.append(carry);
        return builder.reverse();
    }

    public String add(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int a = num1.charAt(i--) - '0';
            int b = num2.charAt(j--) - '0';
            int sum = a + b + carry;
            carry = sum / 10;
            builder.append(sum % 10);
        }
        while (i >= 0) {
            int a = num1.charAt(i--) - '0';
            int sum = a + carry;
            carry = sum / 10;
            builder.append(sum % 10);
        }
        while (j >= 0) {
            int b = num2.charAt(j--) - '0';
            int sum = b + carry;
            carry = sum / 10;
            builder.append(sum % 10);
        }
        if (carry > 0) builder.append(carry);
        builder.reverse();
        return builder.toString();
    }
}

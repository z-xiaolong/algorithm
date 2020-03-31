package leetcode.medium;

import algorithm.chapter10.Stack;

/**
 * @Author long
 * @Date 2020/3/3 21:20
 * @Title 面试题43. 1～n整数中1出现的次数
 * @Description 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 **/

public class CountDigitOne {
    public static void main(String[] args) {
        System.out.println((int) Math.pow(10, 2));
    }

    private int dfs(int n) {
        if (n <= 0) {
            return 0;
        }
        String numStr = String.valueOf(n);
        int high = numStr.charAt(0) - '0';
        int pow = (int) Math.pow(10, numStr.length() - 1);
        int last = n - high * pow;

        if (high == 1) {
            return dfs(pow - 1) + dfs(last) + last + 1;
        } else {
            return pow + high * dfs(pow - 1) + dfs(last);
        }
    }

    // 递归求解
    public int countDigitOne(int n) {
        return dfs(n);
    }
}

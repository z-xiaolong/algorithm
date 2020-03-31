package leetcode.swordOffer.easy;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/3/17 11:45
 * @Title 面试题60. n个骰子的点数
 * @Description //TODO
 **/

public class DiceSum {


    //带备忘录的动态规划：执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        double[] res = new double[5 * n + 1];
        double base = 1 / Math.pow(6, n);
        for (int i = 0; i < res.length; i++) {
            res[i] = getCount(dp, n, n + i) * base;
        }
        return res;
    }

    public int getCount(int[][] dp, int n, int sum) {
        if (n > sum || 6 * n < sum) {
            return 0;
        }
        if (n == sum) {
            return 1;
        }
        if (6 * n == sum) {
            return 1;
        }
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count += getCount(dp, n - 1, sum - i);
        }
        dp[n][sum] = count;
        return count;
    }

    //递归超时
    public double[] twoSumI(int n) {
        double[] res = new double[5 * n + 1];
        double base = 1 / Math.pow(6, n);
        for (int i = 0; i < res.length; i++) {
            res[i] = getCount(n, n + i) * base;
        }
        return res;
    }

    public int getCount(int n, int sum) {
        if (n > sum || 6 * n < sum) {
            return 0;
        }
        if (n == sum) {
            return 1;
        }
        if (6 * n == sum) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count += getCount(n - 1, sum - i);
        }
        return count;
    }
}

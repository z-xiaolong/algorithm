package exam;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/3/30 18:49
 * @Title
 * @Description //TODO
 **/

public class Alibaba {

    public static void main(String[] args) {
        maxExpectation();
    }


    //内存空间O（n）
    public static void maxExpectation() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        double e = 0;
        double p = 2.0 / (((double) n + 1) * (double) n);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            dp[i] = nums[i];
            e += nums[i] * p;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j] = Math.max(dp[j], dp[j + 1]);
                e += dp[j] * p;
            }
        }
        System.out.println(String.format("%.6f", e));//四舍五入
    }

    //子序列的最大值的期望
    //内存空间O(n^2)
    public static void maxExpectationI() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            dp[i][i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
            }
        }
        double e = 0;
        double p = 2.0 / (((double) n + 1) * (double) n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                e += dp[j][j + i] * p;
            }
        }
        System.out.println(String.format("%.6f", e));//四舍五入
    }

}

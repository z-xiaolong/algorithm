package exam;

import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/8/29 15:54
 * @Title
 * @Description:
 */
public class ShunFeng {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();

        }
        long[] sum = new long[n];
        sum[0] = a[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + a[i];
        }
        long[][] dp = new long[n][k + 1];
        dp[0][1] = a[0] * a[0];
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = i - 1; l < j; l++) {
                    long p = sum[j] - sum[l];
                    dp[j][i] = Math.max(dp[l][i - 1] + p * p, dp[j][i]);
                }
            }
        }
        System.out.println(dp[n - 1][k]);
        while (k > 0) {
            int max = 0;
            for (int i = k - 1; i < n - 1; i++) {
                if (dp[i][k - 1] > max) {

                }
            }
        }
        StringBuilder builder = new StringBuilder();
    }

    public static int carNum(int[] a, long mid) {
        int max = 0;
        int sum = 0;
        int count = 0;
        for (int value : a) {
            sum += value;
            if (sum > mid) {
                sum = value;
                max = Math.max(max, count);
                count = 1;
            }
            count++;
        }
        return max;
    }

    public static int check(int[] a, long min, int k) {
        int count = 0;
        int sum = 0;
        for (int value : a) {
            sum += value;
            if (sum > min) {
                count++;
                sum = value;
            }
        }
        if (sum > 0) count++;
        return count;
    }
}

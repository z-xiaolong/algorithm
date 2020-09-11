package exam;

import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/8/1 14:37
 * @Title 奇安信
 * @Description:
 */
public class QiAnXin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int n = in.nextInt();
        int[] P = new int[n + 1];
        int[] W = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            P[i] = in.nextInt();
            W[i] = in.nextInt();
        }
        System.out.println(maxValueII(V, P, W, n));
    }

    public static int maxValue(int V, int[] P, int[] W, int n) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = P[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - P[i]] + W[i]);
            }
        }
        return dp[V];
    }

    public static int maxValueII(int V, int[] P, int[] W, int n) {
        int[][] dp = new int[n + 1][V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = P[i]; j <= V; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - P[i]] + W[i]);
            }
        }
        return dp[n][V];
    }

}

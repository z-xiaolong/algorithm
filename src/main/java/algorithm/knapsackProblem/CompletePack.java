package algorithm.knapsackProblem;

import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/4/23 22:47
 * @Title 完全背包问题
 * @Description //TODO
 **/

public class CompletePack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int[] c = new int[n + 1];
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        System.out.println(maxValue(c, w, n, v));
    }

    public static int maxValue(int[] c, int[] w, int n, int v) {
        int[] dp = new int[v + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = c[i]; j <= v; j++) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + w[i]);
            }
        }
        return dp[v];
    }

}

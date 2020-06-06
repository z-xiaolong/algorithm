package algorithm.knapsackProblem;

import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/5/13 22:21
 * @Title
 * @Description //TODO
 **/

public class TwoDimensionalPack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int M = in.nextInt();
        int[] v = new int[N + 1];
        int[] m = new int[N + 1];
        int[] w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            m[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        int max = maxValue(N, V, M, v, m, w);
        System.out.println(max);
    }


    public static int maxValue(int N, int V, int M, int[] v, int[] m, int[] w) {
        int[][] dp = new int[V + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = M; k >= m[i]; k--) {
                    dp[j][k] = Math.max(dp[j - v[i]][k - m[i]] + w[i], dp[j][k]);
                }
            }
        }
        return dp[V][M];
    }
}

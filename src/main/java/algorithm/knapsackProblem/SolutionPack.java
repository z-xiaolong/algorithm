package algorithm.knapsackProblem;

import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/5/14 17:34
 * @Title
 * @Description //TODO
 **/

public class SolutionPack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        System.out.println(solutionPack(N, V, v, w));
    }

    public static String solutionPack(int N, int V, int[] v, int[] w) {
        int[][] dp = new int[N + 10][V + 1];
        //从后往前面选物品
        for (int i = N; i >= 1; i--) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= v[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - v[i]] + w[i]);
            }
        }
        StringBuilder builder = new StringBuilder();
        int curV = V;
        for (int i = 1; i <= N; i++) {
            if (i == N && curV >= v[i]) {
                builder.append(i);
                break;
            }
            if (curV <= 0) break;
            if (curV - v[i] >= 0 && dp[i][curV] == dp[i + 1][curV - v[i]] + w[i]) {
                builder.append(i).append(" ");
                curV = curV - v[i];
            }
        }
        return builder.toString();
    }
}

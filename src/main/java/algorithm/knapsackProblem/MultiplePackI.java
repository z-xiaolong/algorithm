package algorithm.knapsackProblem;

import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/4/23 23:18
 * @Title 多重背包问题I
 * @Description //TODO
 **/

public class MultiplePackI {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        int[] s = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            s[i] = in.nextInt();
        }
        System.out.println(multiplePack(v, w, s, N, V));
    }

    public static int multiplePack(int[] v, int[] w, int[] s, int N, int V) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = 1; k <= s[i] && k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[V];
    }
}

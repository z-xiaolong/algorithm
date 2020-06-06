package algorithm.knapsackProblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/5/14 17:07
 * @Title
 * @Description //TODO
 **/

public class SolutionsPack {


    static int mod = 1000000007;

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
        System.out.println(solutionsPack(N, V, v, w));
    }

    public static int solutionsPack(int N, int V, int[] v, int[] w) {
        int[] dp = new int[V + 1];
        int[] cnt = new int[V + 1];
        Arrays.fill(cnt, 1);
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                int value = dp[j - v[i]] + w[i];
                if (value > dp[j]) {
                    dp[j] = value;
                    cnt[j] = cnt[j - v[i]];
                } else if (value == dp[j]) {
                    cnt[j] = (cnt[j] + cnt[j - v[i]]) % mod;
                }
            }
        }
        return cnt[V];
    }
}

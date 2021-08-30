package algorithm.knapsackProblem;

import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/5/13 22:51
 * @Title
 * @Description //TODO
 **/

public class PacketPack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            int s = in.nextInt();
            int[] v = new int[s + 1];
            int[] w = new int[s + 1];
            for (int j = 1; j <= s; j++) {
                v[j] = in.nextInt();
                w[j] = in.nextInt();
            }
            for (int j = V; j >= 0; j--) {
                for (int k = 1; k <= s; k++) {
                    if (j >= v[k]) {
                        dp[j] = Math.max(dp[j - v[k]] + w[k], dp[j]);
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }
}

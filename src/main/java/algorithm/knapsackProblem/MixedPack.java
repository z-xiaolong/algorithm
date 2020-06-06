package algorithm.knapsackProblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/4/25 22:40
 * @Title 混合背包问题
 * @Description //TODO
 **/

public class MixedPack {

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
        System.out.println(MixedPack(v, w, s, N, V));
    }

    public static int MixedPack(int[] v, int[] w, int[] s, int N, int V) {
        List<Good> goods = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (s[i] > 0) {
                int count = s[i];
                for (int j = 1; j <= count; j <<= 1) {
                    count -= j;
                    goods.add(new Good(v[i] * j, w[i] * j, -1));
                }
                if (count > 0) goods.add(new Good(v[i] * count, w[i] * count, -1));
            } else {
                goods.add(new Good(v[i], w[i], s[i]));
            }
        }
        int[] dp = new int[V + 1];
        for (Good good : goods) {
            if (good.kind < 0) {
                for (int i = V; i >= good.v; i--) {
                    dp[i] = Math.max(dp[i], dp[i - good.v] + good.w);
                }
            } else {
                for (int i = good.v; i <= V; i++) {
                    dp[i] = Math.max(dp[i], dp[i - good.v] + good.w);
                }
            }
        }
        return dp[V];
    }

    static class Good {
        public int v;
        public int w;
        public int kind;

        public Good(int v, int w, int kind) {
            this.v = v;
            this.w = w;
            this.kind = kind;
        }
    }
}

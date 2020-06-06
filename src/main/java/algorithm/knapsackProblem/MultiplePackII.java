package algorithm.knapsackProblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/4/24 12:07
 * @Title 多重背包问题II
 * @Description //TODO
 **/

public class MultiplePackII {

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
        List<Good> goods = new LinkedList<>();
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            int count = s[i];
            for (int j = 1; j <= count; j <<= 1) {
                count -= j;
                goods.add(new Good(v[i] * j, w[i] * j));
            }
            if (count > 0)
                goods.add(new Good(v[i] * count, w[i] * count));
        }
        for (Good good : goods) {
            for (int i = V; i >= good.v; i--) {
                dp[i] = Math.max(dp[i], dp[i - good.v] + good.w);
            }
        }
        return dp[V];
    }

    static class Good {
        public int v;
        public int w;

        public Good(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}

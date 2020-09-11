package algorithm.knapsackProblem;

import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/4/23 16:06
 * @Title 01 背包问题
 * @Description //TODO
 **/

public class ZeroOnePack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int[] c = new int[n+1];
        int[] w = new int[n+1];
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        System.out.println(maxValue(n, v, c, w));
    }

    //优化后
    public static int maxValue(int n, int v, int[] c, int[] w) {
        int[] dp = new int[v + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = v; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + w[i]);
            }
        }
        return dp[v];
    }


    /*
4 4
-1 -1
1 -1
-1 1
6 6*/

    /**
     * @return 最大价值 max
     * @param: n 物品数量；v 背包容量；c 物品体积；w 物品价值
     */
    public static int maxValueI(int n, int v, int[] c, int[] w) {
        int[][] dp = new int[n + 1][v + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= c[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c[i]] + w[i]);
                }
            }
        }
        int max = 0;
        for (int i : dp[n]) {
            max = Math.max(max, i);
        }
        return max;
    }


}

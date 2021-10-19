package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/9/19 9:57
 * @Title
 * @Description //TODO
 **/

public class MinSteps {

    public int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i - j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - j][j] + 1);
                }
                if (i == j) {
                    for (int k = 1; k <= i; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + 1);
                    }
                }
            }
        }
        int min = n;
        for (int i = 0; i <= n; i++) {
            min = Math.min(min, dp[n][i]);
        }
        return min;
    }
}

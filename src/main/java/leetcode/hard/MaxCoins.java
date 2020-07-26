package leetcode.hard;

/**
 * @Author long
 * @Date 2020/7/19 8:36
 * @Title 312. 戳气球
 * @Description //TODO
 **/

public class MaxCoins {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        val[0] = 1;
        val[n + 1] = 1;
        System.arraycopy(nums, 0, val, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        for (int step = 1; step <= n; step++) {
            for (int i = 1; i + step <= n + 1; i++) {
                int j = i + step - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + val[k] * val[i - 1] * val[j + 1] + dp[k + 1][j]);
                }
            }
        }
        return dp[1][n];
    }
}

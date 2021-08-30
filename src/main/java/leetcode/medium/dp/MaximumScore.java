package leetcode.medium.dp;

/**
 * @Author long
 * @Date 2021/2/22 10:53
 * @Title
 * @Description //TODO
 **/

public class MaximumScore {

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[] dp = new int[m + 1];
        dp[1] = Math.max(multipliers[0] * nums[m - 1], multipliers[0] * nums[0]);
        for (int i = 2; i <= m; i++) {
            int mul = multipliers[i - 1];
            int sum = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                if(j == 0) {

                }
            }
            dp[i] = sum;
        }
        return dp[m];
    }

    public int maximumScore1(int[] nums, int[] multipliers) {
        int n = multipliers.length;
        int m = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][1] = multipliers[0] * nums[m - 1];
        dp[1][0] = multipliers[0] * nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            int mul = multipliers[i - 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[0][i] = dp[0][i - 1] + mul * nums[m - i];
                } else if (j == i) {
                    dp[i][0] = dp[i - 1][0] + mul * nums[i - 1];
                } else {
                    int left = dp[j][i - j - 1] + mul * nums[m - i + j];
                    int right = dp[j - 1][i - j] + mul * nums[j - 1];
                    dp[j][i - j] = Math.max(left, right);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            max = Math.max(dp[i][n - i], max);
        }
        return max;
    }
}

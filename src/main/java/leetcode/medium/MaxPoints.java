package leetcode.medium;

/**
 * @Author long
 * @Date 2021/9/23 11:02
 * @Title
 * @Description //TODO
 **/

public class MaxPoints {

    /*
     * dp[i][j] = max(dp[i-1][k] + points[i][j] - abs(j - k)); 0 <= k < n
     * dp[i][j] = dp[i-1][k] + points[i][j] - |j - k|;
     * dp[i][j] = points[i][j] + j + max(dp[i-1][k] - k); j <= k
     *          = points[i][j] - j + max(dp[i-1][k] + k); j >= k
     * */
    public long maxPoints(int[][] points) {
        int n = points[0].length;
        long[] dp = new long[n];
        long[] left = new long[n];
        long[] right = new long[n];
        for (int[] point : points) {
            left[0] = dp[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1], dp[j] + j);
            }
            right[n - 1] = dp[n - 1] - n + 1;
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[j] - j);
            }
            for (int j = 0; j < n; j++) {
                long l = point[j] - j + left[j];
                long r = point[j] + j + right[j];
                dp[j] = Math.max(l, r);
            }
        }

        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

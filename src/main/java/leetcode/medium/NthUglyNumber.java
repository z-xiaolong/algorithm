package leetcode.medium;

/**
 * @Author long
 * @Date 2020/4/11 11:06
 * @Title 264. 丑数 II
 * @Description //TODO
 **/

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
        }
        return dp[n];
    }
}

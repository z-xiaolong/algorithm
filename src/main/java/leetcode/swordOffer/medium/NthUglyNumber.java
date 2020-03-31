package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/3/20 11:07
 * @Title 面试题49. 丑数
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
            int min = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            dp[i] = min;
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
        }
        return dp[n];
    }
}

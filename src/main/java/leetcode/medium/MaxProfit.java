package leetcode.medium;

/**
 * @Author long
 * @Date 2020/7/10 10:15
 * @Title 309. 最佳买卖股票时机含冷冻期
 * @Description //TODO
 **/

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int state1 = -prices[0];
        int state2 = 0;
        int state3 = 0;
        for (int i = 1; i < n; i++) {
            int temp1 = state1;
            int temp2 = state2;
            state1 = Math.max(temp1, state3 - prices[i]);
            state2 = temp1 + prices[i];
            state3 = Math.max(temp2, state3);
        }
        return Math.max(state2, state3);
    }

    public int maxProfitI(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}

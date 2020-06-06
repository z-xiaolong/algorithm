package leetcode.medium.dp;

/**
 * @Author long
 * @Date 2020/5/26 13:21
 * @Title 518. 零钱兑换 II
 * @Description 完全背包问题求方案数
 **/

public class Change {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}

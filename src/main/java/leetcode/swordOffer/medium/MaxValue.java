package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/3/23 11:28
 * @Title 面试题47. 礼物的最大价值
 * @Description //TODO
 **/

public class MaxValue {

    //动态规划： 执行用时 :2 ms, 在所有 Java 提交中击败了98.30%的用户
    public int maxValue(int[][] grid) {
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = grid[0][i - 1] + dp[i - 1]; //初始化
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j <= n; j++) {
                int value = Math.max(dp[j - 1], dp[j]);
                dp[i] = value + grid[i][j - 1];
            }
        }
        return dp[n];
    }
}

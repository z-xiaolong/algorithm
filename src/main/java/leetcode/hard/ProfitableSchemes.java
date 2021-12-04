package leetcode.hard;

/**
 * @Author long
 * @Date 2021/11/13 19:24
 * @Title
 * @Description 多维背包问题
 **/

public class ProfitableSchemes {

    public static void main(String[] args) {
        ProfitableSchemes p = new ProfitableSchemes();
        p.profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8});
    }

    int mod = (int) 1e9 + 7;

    //dp[i][j] = dp[i-group[k]][j-profit[k]]
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = profit.length;
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = n; j >= group[i]; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - group[i]][Math.max(0, k - profit[i])]) % mod;
                }
            }
        }
        return dp[n][minProfit];
    }


}

package leetcode.medium.dp;

/**
 * @Author long
 * @Date 2021/2/22 11:44
 * @Title
 * @Description //TODO
 **/

public class StoneGame {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        System.arraycopy(piles, 0, dp, 0, n);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] > 0;
    }
}

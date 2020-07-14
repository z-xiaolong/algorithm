package leetcode.hard;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/7/12 9:31
 * @Title 174. 地下城游戏
 * @Description //TODO
 **/

public class CalculateMinimumHP {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0, -3}};
        CalculateMinimumHP hp = new CalculateMinimumHP();
        hp.calculateMinimumHP(nums);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            dp[m - 1] = Math.max(dp[m - 1] - dungeon[i][m - 1], 1);
            for (int j = m - 2; j >= 0; j--) {
                dp[j] = Math.min(dp[j], dp[j + 1]);
                dp[j] = Math.max(dp[j] - dungeon[i][j], 1);
            }
        }
        return dp[0];
    }

    //执行用时：3 ms, 在所有 Java 提交中击败了41.26%的用户
    public int calculateMinimumHPI(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i + 1 < n && j + 1 < m) {
                    dp[i][j] = dp[i + 1][j] - dungeon[i][j];
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] - dungeon[i][j]);
                } else if (i + 1 < n) {
                    dp[i][j] = dp[i + 1][j] - dungeon[i][j];
                } else if (j + 1 < m) {
                    dp[i][j] = dp[i][j + 1] - dungeon[i][j];
                } else {
                    dp[i][j] = 1 - dungeon[i][j];
                }
                if (dp[i][j] <= 0) {
                    dp[i][j] = 1;
                }
            }
        }
        return dp[0][0];
    }
}

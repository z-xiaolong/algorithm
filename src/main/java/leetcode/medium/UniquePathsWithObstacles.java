package leetcode.medium;

/**
 * @Author long
 * @Date 2020/7/6 8:56
 * @Title
 * @Description //TODO
 **/

public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int[] dp = new int[m];
        if (obstacleGrid[0][0] == 0) dp[0] = 1;
        for (int[] grid : obstacleGrid) {
            if (grid[0] == 1) dp[0] = 0;
            for (int j = 1; j < m; j++) {
                if (grid[j] == 0) {
                    dp[j] += dp[j - 1];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[m - 1];
    }
}

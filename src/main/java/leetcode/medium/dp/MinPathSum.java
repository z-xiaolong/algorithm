package leetcode.medium.dp;

/**
 * @Author long
 * @Date 2020/2/20 19:05
 * @Title 64. 最小路径和
 * @Description 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。说明：每次只能向下或者向右移动一步。
 **/

public class MinPathSum {

    public static void main(String[] args) {
        int[][] array = new int[4][3];
        System.out.println(array.length);
        System.out.println(array[0].length);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m && j < n) {
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                } else if (i == m && j < n) {
                    grid[i][j] = grid[i][j + 1] + grid[i][j];
                } else if (i < m) {
                    grid[i][j] = grid[i + 1][j] + grid[i][j];
                }
            }
        }
        return grid[0][0];
    }

    public int minPathSum1(int[][] grid) {
        return minPathSum(grid, new int[grid.length][grid[0].length], grid.length - 1, grid[0].length - 1);
    }

    public int minPathSum(int[][] grid, int[][] dp, int m, int n) {
        if (dp[m][n] > 0) {
            return dp[m][n];
        }
        int value = Integer.MAX_VALUE;
        if (m > 0) {
            value = Math.min(value, minPathSum(grid, dp, m - 1, n) + grid[m][n]);
        }
        if (n > 0) {
            value = Math.min(value, minPathSum(grid, dp, m, n - 1) + grid[m][n]);
        }
        if (m == 0 && n == 0) {
            value = grid[0][0];
        }
        dp[m][n] = value;
        return dp[m][n];
    }
}

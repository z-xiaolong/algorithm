package leetcode.medium;

/**
 * @Author long
 * @Date 2020/5/8 9:39
 * @Title 221. 最大正方形
 * @Description //TODO
 **/

public class MaximalSquare {


    //优化内存为 O(n)
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int columns = matrix[0].length;
        int max = 0;
        int[] dp = new int[columns];
        for (int i = 0; i < rows; i++) {
            int pre = dp[0];
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    int temp = dp[j];
                    if (i == 0 || j == 0) {
                        dp[j] = 1;
                    } else {
                        dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), pre) + 1;
                    }
                    pre = temp;
                    max = Math.max(max, dp[j]);
                } else {
                    pre = dp[j];
                    dp[j] = 0;
                }
            }
        }
        return max * max;
    }

    public int maximalSquareI(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int columns = matrix[0].length;
        int max = 0;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}

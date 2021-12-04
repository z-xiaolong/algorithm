package leetcode.medium;

/**
 * @Author long
 * @Date 2021/10/27 16:29
 * @Title
 * @Description //TODO
 **/

public class CountSquares {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int pre = dp[0];
            for (int j = 0; j < n; j++) {
                int temp = dp[j];
                if (matrix[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        dp[j] = Math.min(dp[j], Math.min(dp[j - 1], pre)) + 1;
                    } else {
                        dp[j] = 1;
                    }
                } else {
                    dp[j] = 0;
                }
                pre = temp;
                sum += dp[j];
            }
        }
        return sum;
    }
}

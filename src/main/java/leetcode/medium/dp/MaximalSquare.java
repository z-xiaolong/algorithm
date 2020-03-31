package leetcode.medium.dp;

/**
 * @Author long
 * @Date 2020/3/5 16:18
 * @Title 221. 最大正方形
 * @Description 在一个由 0 和 1 组成的二维矩阵内，
 * 找到只包含 1 的最大正方形，并返回其面积。
 **/

public class MaximalSquare {

    //动态规划
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int max = 0;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (matrix[i][m - 1] == '1') {
                nums[i][m - 1] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[n - 1][i] == '1') {
                nums[n - 1][i] = 1;
                max = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    int min = Math.min(nums[i + 1][j], nums[i][j + 1]);
                    min = Math.min(nums[i + 1][j + 1], min);
                    nums[i][j] = min + 1;
                    max = Math.max(nums[i][j], max);
                } else {
                    nums[i][j] = 0;
                }
            }
        }
        return max * max;
    }

}

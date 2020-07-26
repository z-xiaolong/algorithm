package leetcode.hard;

/**
 * @Author long
 * @Date 2020/7/26 9:55
 * @Title 329. 矩阵中的最长递增路径
 * @Description //TODO
 **/

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] memory = new int[n][m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (memory[i][j] == 0) {
                    max = Math.max(dfs(matrix, memory, i, j), max);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int[][] memory, int i, int j) {
        if (memory[i][j] != 0) return memory[i][j];
        int n = matrix.length;
        int m = matrix[0].length;
        int value = matrix[i][j];
        int length = 0;
        if (i + 1 < n && value < matrix[i + 1][j]) {
            length = Math.max(dfs(matrix, memory, i + 1, j), length);
        }
        if (i - 1 >= 0 && value < matrix[i - 1][j]) {
            length = Math.max(dfs(matrix, memory, i - 1, j), length);
        }
        if (j + 1 < m && value < matrix[i][j + 1]) {
            length = Math.max(dfs(matrix, memory, i, j + 1), length);
        }
        if (j - 1 >= 0 && value < matrix[i][j - 1]) {
            length = Math.max(dfs(matrix, memory, i, j - 1), length);
        }
        memory[i][j] = length + 1;
        return memory[i][j];
    }
}

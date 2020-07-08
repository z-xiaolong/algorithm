package leetcode.byteDance;

/**
 * @Author long
 * @Date 2020/6/24 10:38
 * @Title
 * @Description //TODO
 **/

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] flag = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !flag[i][j]) {
                    maxArea = Math.max(maxArea, dfs(grid, flag, i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, boolean[][] flag, int i, int j) {
        int sum = 1;
        int r = grid.length;
        int c = grid[0].length;
        flag[i][j] = true;
        if (i - 1 >= 0 && !flag[i - 1][j] && grid[i - 1][j] == 1) {
            sum += dfs(grid, flag, i - 1, j);
        }
        if (j - 1 >= 0 && !flag[i][j - 1] && grid[i][j - 1] == 1) {
            sum += dfs(grid, flag, i, j - 1);
        }
        if (i + 1 < r && !flag[i + 1][j] && grid[i + 1][j] == 1) {
            sum += dfs(grid, flag, i + 1, j);
        }
        if (j + 1 < c && !flag[i][j + 1] && grid[i][j + 1] == 1) {
            sum += dfs(grid, flag, i, j + 1);
        }
        return sum;
    }
}

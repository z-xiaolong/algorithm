package leetcode.medium;

/**
 * @Author long
 * @Date 2020/3/15 9:45
 * @Title 695. 岛屿的最大面积
 * @Description //TODO
 **/

public class MaxAreaOfIsland {

    //dfs：执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
    public int maxAreaOfIsland(int[][] grid) {
        int c = grid.length;
        if (c == 0) {
            return 0;
        }
        int r = grid[0].length;
        int max = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        int c = grid.length;
        int r = grid[0].length;
        int count = 1;
        grid[i][j] = -1;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            count += dfs(grid, i - 1, j);
        }
        if (i + 1 < c && grid[i + 1][j] == 1) {
            count += dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            count += dfs(grid, i, j - 1);
        }
        if (j + 1 < r && grid[i][j + 1] == 1) {
            count += dfs(grid, i, j + 1);
        }
        return count;
    }
}

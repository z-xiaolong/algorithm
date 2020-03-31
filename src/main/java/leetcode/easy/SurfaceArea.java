package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/25 9:43
 * @Title 892. 三维形体的表面积
 * @Description //TODO
 **/

public class SurfaceArea {

    //执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += computeArea(grid, n, i, j);
            }
        }
        return sum;
    }

    public int computeArea(int[][] grid, int n, int i, int j) {
        int current = grid[i][j];
        if (current == 0) {
            return 0;
        }
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        if (i - 1 >= 0) {
            up = Math.min(grid[i - 1][j], current);
        }
        if (i + 1 < n) {
            down = Math.min(grid[i + 1][j], current);
        }
        if (j - 1 >= 0) {
            left = Math.min(grid[i][j - 1], current);
        }
        if (j + 1 < n) {
            right = Math.min(grid[i][j + 1], current);
        }
        return current * 6 - (current - 1) * 2 - (up + down + left + right);
    }
}

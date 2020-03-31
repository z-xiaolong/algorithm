package leetcode.medium;

/**
 * @Author long
 * @Date 2019/12/7 21:43
 * @Title 200. 岛屿数量
 * @Description 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 **/

public class NumIslands {

    public static void main(String[] args) {
        int[][] numbers = new int[4][5];
        System.out.println(numbers[1].length);
        System.out.println(numbers.length);
        System.out.println(NumIslands.class.getName());
    }

    //dfs：执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public int numIslands(char[][] grid) {
        int c = grid.length;
        if (c == 0) {
            return 0;
        }
        int r = grid[0].length;
        int max = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (grid[i][j] == '1') {
                    max++;
                    dfs(grid, i, j);
                }
            }
        }
        return max;
    }

    public void dfs(char[][] grid, int i, int j) {
        int c = grid.length;
        int r = grid[0].length;
        grid[i][j] = '2';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (i + 1 < c && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (j + 1 < r && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
    }
}

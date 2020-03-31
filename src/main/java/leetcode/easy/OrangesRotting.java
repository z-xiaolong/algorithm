package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/3/4 11:05
 * @Title 994. 腐烂的橘子
 * @Description 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 **/

public class OrangesRotting {

    //暴力法
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    nums[i][j] = 0;
                } else {
                    nums[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 0) {
                    recursion(grid, nums, i, j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] > max) {
                    max = nums[i][j];
                }
            }
        }
        if (max > 100) {
            return -1;
        }
        return max;
    }

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int bfs(int[][] grid) {
        Queue<Coordinate> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    nums[i][j] = -1;
                    queue.add(new Coordinate(i, j));
                } else {
                    nums[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int max = 0;
        while (!queue.isEmpty()) {
            Coordinate c = queue.poll();
            int min = nums[c.x][c.y];
            for (int i = 0; i < 4; i++) {
                int x = c.x + dr[i];
                int y = c.y + dc[i];
                if (x < n && y < m && x >= 0 && y >= 0) {
                    if (grid[x][y] == 1) {
                        queue.add(new Coordinate(x, y));
                        grid[x][y] = 2;
                    }
                    min = Math.min(min, nums[x][y]);
                }
            }
            nums[c.x][c.y] = min + 1;
            max = Math.max(max, min + 1);
        }
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return max;
    }

    class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void recursion(int[][] grid, int[][] nums, int i, int j) {
        int n = nums.length;
        int m = nums[0].length;
        if (i > n || i < 0 || j > m || j < 0) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        if (i + 1 < n) {
            nums[i][j] = Math.min(nums[i][j], nums[i + 1][j]);
        }
        if (j + 1 < n) {
            nums[i][j] = Math.min(nums[i][j], nums[i][j + 1]);
        }
        if (i - 1 >= 0) {
            nums[i][j] = Math.min(nums[i][j], nums[i - 1][j]);
        }
        if (j - 1 >= 0) {
            nums[i][j] = Math.min(nums[i][j], nums[i][j - 1]);
        }
        nums[i][j]++;
        recursion(grid, nums, i + 1, j);
        recursion(grid, nums, i - 1, j);
        recursion(grid, nums, i, j + 1);
        recursion(grid, nums, i, j - 1);
    }


}

package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/3/29 9:30
 * @Title 1162. 地图分析
 * @Description //TODO
 **/

public class MaxDistance {

    //多源广度优先搜索：执行用时 :15 ms, 在所有 Java 提交中击败了92.84%的用户
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        boolean[][] flag = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    flag[i][j] = true;
                }
            }
        }
        if (queue.size() == 0 || queue.size() == n * m) {
            return -1;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] coordinate = queue.poll();
                int i = coordinate[0];
                int j = coordinate[1];
                search(queue, distance, flag, i - 1, j, distance[i][j]);
                search(queue, distance, flag, i + 1, j, distance[i][j]);
                search(queue, distance, flag, i, j - 1, distance[i][j]);
                search(queue, distance, flag, i, j + 1, distance[i][j]);
                size--;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(distance[i][j], max);
            }
        }
        return max;
    }

    public void search(Queue<int[]> queue, int[][] distance, boolean[][] flag, int i, int j, int value) {
        if (i >= 0 && i < distance.length && j < distance[0].length && j >= 0 && !flag[i][j]) {
            distance[i][j] = value + 1;
            flag[i][j] = true;
            queue.add(new int[]{i, j});
        }
    }

}

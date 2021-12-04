package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2021/10/4 17:11
 * @Title
 * @Description //TODO
 **/

public class TrapRainWater {

    public static void main(String[] args) {
        int[][] heightMap = new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        trapRainWater(heightMap);
    }

    public static int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        if (n <= 2 || m <= 2) return 0;
        int ans = 0;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    queue.add(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int[] dirX = new int[]{0, 1, 0, -1};
        int[] dirY = new int[]{1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dirX[i];
                int nextY = cur[1] + dirY[i];
                if (nextX > 0 && nextX < n && nextY > 0 && nextY < m && !visited[nextX][nextY]) {
                    if (heightMap[nextX][nextY] < cur[2]) {
                        ans += cur[2] - heightMap[nextX][nextY];
                    }
                    queue.add(new int[]{nextX, nextY, Math.max(cur[2], heightMap[nextX][nextY])});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return ans;
    }
}

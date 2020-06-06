package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/4/15 10:37
 * @Title 542. 01 矩阵
 * @Description //TODO
 **/

public class UpdateMatrix {

    //执行用时 :19 ms, 在所有 Java 提交中击败了55.81%的用户
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] output = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] c = queue.poll();
                int x = c[0];
                int y = c[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && output[nx][ny] == 0 && matrix[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        output[nx][ny] = output[x][y] + 1;
                    }
                }
                size--;
            }

        }
        return output;
    }

}

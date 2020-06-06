package leetcode.medium;

import java.util.jar.JarEntry;

/**
 * @Author long
 * @Date 2020/4/2 11:11
 * @Title 289. 生命游戏
 * @Description //TODO
 **/

public class GameOfLife {
    int[] x = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
    int[] y = new int[]{1, -1, 0, 1, -1, -1, 0, 1};


    //复制数组
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(board[i], 0, temp[i], 0, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = getLiveNum(temp, m, n, i, j);
                if (num < 2) {
                    board[i][j] = 0;
                } else if (num == 3) {
                    board[i][j] = 1;
                } else if (num > 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public int getLiveNum(int[][] board, int m, int n, int i, int j) {
        int num = 0;
        for (int k = 0; k < x.length; k++) {
            int curX = i + x[k];
            int curY = j + y[k];
            if (curX >= 0 && curX < m && curY >= 0 && curY < n && board[curX][curY] == 1) {
                num++;
            }
        }
        return num;
    }
}

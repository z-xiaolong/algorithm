package leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2021/11/18 21:49
 * @Title
 * @Description //TODO
 **/

public class IsPrintable {

    public static void main(String[] args) {
        IsPrintable printable = new IsPrintable();
        int[][] t = new int[][]{{1, 1, 1, 1}, {1, 1, 3, 3}, {1, 1, 3, 4}, {5, 5, 1, 4}};
        printable.isPrintable(t);
    }

    public boolean isPrintable(int[][] targetGrid) {
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        int[][] color = new int[61][4];
        for (int i = 0; i < color.length; i++) {
            color[i] = new int[]{100, -1, 100, -1};
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = targetGrid[i][j];
                color[c][0] = Math.min(color[c][0], j);
                color[c][1] = Math.max(color[c][1], j);
                color[c][2] = Math.min(color[c][2], i);
                color[c][3] = Math.max(color[c][3], i);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int[] c : color) {
            if (check(targetGrid, c)) queue.add(c);
        }
        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            fill(targetGrid, c);
            if (queue.isEmpty()) {
                for (int[] co : color) {
                    if (check(targetGrid, co)) queue.add(co);
                }
            }
        }
        for (int[] ints : targetGrid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] != 0) return false;
            }
        }
        return true;
    }

    public void fill(int[][] targetGrid, int[] color) {
        for (int i = color[0]; i <= color[1]; i++) {
            for (int j = color[2]; j <= color[3]; j++) {
                targetGrid[j][i] = 0;
            }
        }
    }

    public boolean check(int[][] targetGrid, int[] color) {
        int value = -1;
        for (int k : color) {
            if (k < 0 || k > 60) return false;
        }
        for (int i = color[0]; i <= color[1]; i++) {
            for (int j = color[2]; j <= color[3]; j++) {
                int v = targetGrid[j][i];
                if (v != 0) {
                    if (value != -1 && value != v) return false;
                    else value = v;
                }
            }
        }
        return value != -1;
    }

}

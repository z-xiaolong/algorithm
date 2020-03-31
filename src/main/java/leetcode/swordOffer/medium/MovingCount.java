package leetcode.swordOffer.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/3/27 17:07
 * @Title 面试题13. 机器人的运动范围
 * @Description //TODO
 **/

public class MovingCount {


    public static void main(String[] args) {
        MovingCount count = new MovingCount();
        count.movingCount(2, 3, 1);
    }

    //dfs
    private int count = 0;

    //执行用时 :1 ms, 在所有 Java 提交中击败了91.62%的用户
    public int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        dfs(flag, 0, 0, k);
        return count;
    }


    public void dfs(boolean[][] flag, int i, int j, int k) {
        flag[i][j] = true;
        if (check(i, j, k)) {
            count++;
        } else {
            return;
        }
        if (i - 1 >= 0 && !flag[i - 1][j]) {
            dfs(flag, i - 1, j, k);
        }
        if (i + 1 < flag.length && !flag[i + 1][j]) {
            dfs(flag, i + 1, j, k);
        }
        if (j - 1 >= 0 && !flag[i][j - 1]) {
            dfs(flag, i, j - 1, k);
        }
        if (j + 1 < flag[0].length && !flag[i][j + 1]) {
            dfs(flag, i, j + 1, k);
        }
    }


    //bfs: 执行用时 :6 ms, 在所有 Java 提交中击败了21.40%的用户
    public int movingCountI(int m, int n, int k) {
        int[][] flag = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        queue.add(new int[]{0, 0});
        flag[0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] coordinate = queue.poll();
                int i = coordinate[0];
                int j = coordinate[1];
                if (i + 1 < m && check(i + 1, j, k) && flag[i + 1][j] == 0) {
                    queue.add(new int[]{i + 1, j});
                    flag[i + 1][j] = 1;
                    count++;
                }
                if (i - 1 >= 0 && check(i - 1, j, k) && flag[i - 1][j] == 0) {
                    queue.add(new int[]{i - 1, j});
                    flag[i - 1][j] = 1;
                    count++;
                }
                if (j + 1 < n && check(i, j + 1, k) && flag[i][j + 1] == 0) {
                    queue.add(new int[]{i, j + 1});
                    flag[i][j + 1] = 1;
                    count++;
                }
                if (j - 1 >= 0 && check(i, j - 1, k) && flag[i][j - 1] == 0) {
                    queue.add(new int[]{i, j - 1});
                    flag[i][j - 1] = 1;
                    count++;
                }
                size--;
            }
        }
        return count;
    }

    public boolean check(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum += j % 10;
            j = j / 10;
        }
        return sum <= k;
    }
}

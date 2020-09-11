package exam;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: long
 * @Date: 2020/8/9 16:48
 * @Title
 * @Description:
 */
public class Tiger {

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        int[][] trips = new int[][]{{2, 1, 4}, {4, 2, 6}};
        int re = tiger.minCarCount(trips, 5);
        System.out.println(re);
    }

    public int minCarCount(int[][] trips, int capacity) {
        int count = 0;
        if (trips.length == 0) return 0;
        int[] dp = new int[10010];
        int end = 0;
        for (int[] trip : trips) {
            dp[trip[1]] += trip[0];
            dp[trip[2]] -= trip[0];
            end = Math.max(end,trip[2]);
        }
        for (int i = 0; i <= end; i++) {
            if (i != 0) dp[i] += dp[i - 1];
            count = Math.max(count, dp[i]);
        }
        if (count % capacity == 0) return count / capacity;
        return count / capacity + 1;
    }


    public int maxLevel(int x, int level, int[][] tasks) {
        Arrays.sort(tasks, (o1, o2) -> o2[1] - o1[1]);
        int n = tasks.length;
        boolean[] flag = new boolean[n];
        while (x > 0) {
            for (int i = 0; i < n; i++) {
                if (level >= tasks[i][0] && !flag[i]) {
                    level += tasks[i][1];
                    flag[i] = true;
                    break;
                }
            }
            x--;
        }
        Thread.yield();

        return level;
    }

}

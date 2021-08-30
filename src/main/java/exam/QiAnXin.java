package exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/8/1 14:37
 * @Title 奇安信
 * @Description:
 */
public class QiAnXin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int m = in.nextInt();
        int[] s = new int[m + 1];
        int[] v = new int[m + 1];
        int[] w = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            s[i] = in.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            v[i] = in.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            w[i] = in.nextInt();
        }
        int[] dp = new int[x + 1];
        for (int i = 1; i <= x; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = x; j >= v[i]; j--) {
                for (int k = 1; k <= s[i] && k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        System.out.println(dp[x]);
    }

    public int AttendMeetings(int[][] times) {
        if (times.length == 0) {
            return 0;
        }
        Arrays.sort(times, Comparator.comparingInt(o -> o[1]));
        int max = 1;
        int end = times[0][1];
        for (int i = 1; i < times.length; i++) {
            if (times[i][0] >= end) {
                max++;
                end = times[i][1];
            }
        }
        return max;
    }


    public static int maxValue(int V, int[] P, int[] W, int n) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = P[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - P[i]] + W[i]);
            }
        }
        return dp[V];
    }

    public static int maxValueII(int V, int[] P, int[] W, int n) {
        int[][] dp = new int[n + 1][V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = P[i]; j <= V; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - P[i]] + W[i]);
            }
        }
        return dp[n][V];
    }

}

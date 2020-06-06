package leetcode.medium.dp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/4/12 9:44
 * @Title 279. 完全平方数
 * @Description //TODO
 **/

public class NumSquares {

    //BFS
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size > 0) {
                int num = queue.poll();
                if (num == 0) return level - 1;
                for (int i = 1; i * i <= num; i++) {
                    queue.add(num - i * i);
                }
                size--;
            }
        }
        return level;
    }

    //带备忘录的dp:执行用时 :84 ms, 在所有 Java 提交中击败了22.74%的用户
    public int dp(int[] dp, int i) {
        if (i == 0) return 0;
        if (dp[i] != 0) return dp[i];
        if (i == 1) {
            dp[i] = 1;
            return dp[i];
        } else {
            int min = i;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp(dp, i - j * j));
            }
            dp[i] = min + 1;
            return dp[i];
        }
    }

    //执行用时 :42 ms, 在所有 Java 提交中击败了55.13%的用户
    public int numSquaresI(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j]);
            }
            dp[i]++;
        }
        return dp[n];
    }
}

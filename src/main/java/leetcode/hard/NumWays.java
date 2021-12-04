package leetcode.hard;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/11/10 11:27
 * @Title
 * @Description //TODO
 **/

public class NumWays {

    int mod = (int) (1e9 + 7);

    public int numWays(int steps, int arrLen) {
        if (arrLen == 1) return 1;
        int len = Math.min(steps, arrLen);
        int[] dp = new int[len];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < steps; i++) {
            int prev = dp[0];
            for (int j = 0; j < len; j++) {
                int tmp = dp[j];
                if (j > 0) dp[j] = (dp[j] + prev) % mod;
                if (j < len - 1) dp[j] = (dp[j] + dp[j + 1]) % mod;
                prev = tmp;
            }
        }
        return dp[0] % mod;
    }

    //超时
    public int numWays_(int steps, int arrLen) {
        if (arrLen == 1) return 1;
        int[] dp = new int[arrLen];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < steps; i++) {
            int prev = dp[0];
            for (int j = 0; j < arrLen; j++) {
                int tmp = dp[j];
                if (j > 0) dp[j] = (dp[j] + prev) % mod;
                if (j < arrLen - 1) dp[j] = (dp[j] + dp[j + 1]) % mod;
                prev = tmp;
            }
        }
        return dp[0] % mod;
    }

    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[4];
    }

}

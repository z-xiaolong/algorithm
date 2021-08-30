package leetcode.hard;

/**
 * @Author long
 * @Date 2021/4/16 13:09
 * @Title
 * @Description //TODO
 **/

public class IsScramble {

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n != m) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chars1[i] == chars2[i]) {
                    dp[i][j][1] = true;
                }
            }
        }
        for (int step = 2; step <= n; step++) {
            for (int i = 0; i <= n - step; i++) {
                for (int j = 0; j <= n - step; j++) {
                    for (int k = 1; k < step; k++) {
                        if (dp[i][j][k] && dp[i + k][j + k][step - k]) {
                            dp[i][j][step] = true;
                            break;
                        }
                        if (dp[i][j + step - k][k] && dp[i + k][j][step - k]) {
                            dp[i][j][step] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}

package leetcode.hard;

/**
 * @Author long
 * @Date 2020/7/18 8:45
 * @Title 97. 交错字符串
 * @Description //TODO
 **/

public class IsInterleave {


    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int len = s3.length();
        if (n + m != len) return false;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int k = i + j - 1;
                if (i > 0) {
                    dp[i][j] |= dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k);
                }
                if (j > 0) {
                    dp[i][j] |= dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k);
                }
            }
        }
        return dp[n][m];
    }


    //执行用时：10 ms, 在所有 Java 提交中击败了19.75%的用户
    public boolean isInterleaveI(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int len = s3.length();
        if (n + m != len) return false;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int k = i + j;
                if (k == 0) continue;
                char c = s3.charAt(k - 1);
                if (i != 0 && s1.charAt(i - 1) == c) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
                if (j != 0 && s2.charAt(j - 1) == c) {
                    dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[n][m] == len;
    }
}

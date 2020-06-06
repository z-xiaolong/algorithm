package leetcode.medium;

/**
 * @Author long
 * @Date 2020/5/21 19:09
 * @Title
 * @Description //TODO
 **/

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int max = 0;
        int left = 0;
        int right = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    if (i == 1) dp[j][j + i] = true;
                    else dp[j][j + i] = dp[j + 1][j + i - 1];
                    if (dp[j][j + i] && i > max) {
                        max = i;
                        left = j;
                        right = j + i + 1;
                    }
                }
            }
        }
        return s.substring(left, right);
    }
}

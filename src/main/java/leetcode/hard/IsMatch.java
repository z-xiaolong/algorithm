package leetcode.hard;

/**
 * @Author long
 * @Date 2020/7/5 9:46
 * @Title 44. 通配符匹配
 * @Description //TODO
 **/

public class IsMatch {

    public static void main(String[] args) {
        IsMatch match = new IsMatch();
        match.isMatch("adceb", "*a*b");
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        if (m == 0) {
            return "*".equals(p) || "".equals(p);
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        int k = 0;
        while (k < n && p.charAt(k) == '*') {
            dp[++k][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            char c = p.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char temp = s.charAt(j - 1);
                if (c == temp || c == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }


}

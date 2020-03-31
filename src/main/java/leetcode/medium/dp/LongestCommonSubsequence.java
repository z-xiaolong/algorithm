package leetcode.medium.dp;

/**
 * @Author long
 * @Date 2020/3/13 20:59
 * @Title 1143. 最长公共子序列
 * @Description //TODO
 **/

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        longestCommonSubsequence("bbnm", "mjbj");
    }

    //经典动态规划题目，重点
    //执行用时 :14 ms, 在所有 Java 提交中击败了37.58%的用户
    public static int longestCommonSubsequenceI(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    //内存优化: 执行用时 :12 ms, 在所有 Java 提交中击败了52.12%的用户
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[m + 1];
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            temp = 0;
            for (int j = 1; j <= m; j++) {
                int k = dp[j];
                if (text2.charAt(i - 1) == text1.charAt(j - 1)) {
                    dp[j] = temp + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                temp = k;
            }
        }
        return dp[m];
    }
}

package leetcode.medium;

/**
 * @Author long
 * @Date 2021/10/15 20:40
 * @Title
 * @Description //TODO
 **/

public class FindMaxForm {

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        FindMaxForm findMaxForm = new FindMaxForm();
        findMaxForm.findMaxForm(strs, 5, 3);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zero = 0;
            int one = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') one++;
                else zero++;
            }
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int cnt(String str) {
        int n = str.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') cnt++;
        }
        return cnt;
    }
}

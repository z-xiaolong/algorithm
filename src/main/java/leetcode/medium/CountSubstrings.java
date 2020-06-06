package leetcode.medium;

/**
 * @Author long
 * @Date 2020/4/17 11:38
 * @Title 647. 回文子串
 * @Description //TODO
 **/

public class CountSubstrings {


    //官方答案I 中心扩展：执行用时 :4 ms, 在所有 Java 提交中击败了75.68%的用户
    public int countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2 * N - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    //dp：执行用时 :13 ms, 在所有 Java 提交中击败了35.73%的用户
    public int countSubstringsI(String s) {
        int length = s.length();
        if (length == 0) return 0;
        int count = length;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        for (int i = 2; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}

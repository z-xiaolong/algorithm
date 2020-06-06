package leetcode.swordOffer.hard;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/4/6 10:06
 * @Title 72. 编辑距离
 * @Description //TODO
 **/

public class MinDistance {

    public static void main(String[] args) {
        minDistance("spake", "");
    }

    //空间复杂度O(n),执行用时 :5 ms, 在所有 Java 提交中击败了97.81%的用户
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            dp[0] = i;
            int prev = i;
            for (int j = 0; j < m; j++) {
                int temp = dp[j + 1];
                if (word1.charAt(j) == word2.charAt(i)) {
                    dp[j + 1] = prev;
                } else {
                    dp[j + 1] = Math.min(Math.min(dp[j], dp[j + 1]), prev) + 1;
                }
                prev = temp;
            }
        }
        return dp[m];
    }
}

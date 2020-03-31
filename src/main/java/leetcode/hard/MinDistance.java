package leetcode.hard;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/19 21:28
 * @Title 72. 编辑距离
 * @Description //TODO
 **/

public class MinDistance {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        MinDistance minDistance = new MinDistance();
        minDistance.minDistance(word1, word2);
    }

    //
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 == 0 || length2 == 0) {
            return Math.max(length1, length2);
        }
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[length1][length2];
    }

    //自底向上：执行用时 :6 ms, 在所有 Java 提交中击败了91.40%的用户
    public int minDistanceII(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 == 0 || length2 == 0) {
            return Math.max(length1, length2);
        }
        int[][] dp = new int[length1][length2];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 1; i < dp[0].length; i++) {
            if (word1.charAt(0) == word2.charAt(i)) {
                dp[0][i] = i;
            } else {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = i;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[length1 - 1][length2 - 1];
    }


    //带备忘录的递归：执行用时 :7 ms, 在所有 Java 提交中击败了75.35%的用户
    public int minDistanceI(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 == 0 || length2 == 0) {
            return Math.max(length1, length2);
        }
        int[][] dp = new int[length1][length2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dp(word1, word2, dp, length1 - 1, length2 - 1);
    }

    public int dp(String word1, String word2, int[][] dp, int i, int j) {
        char char1 = word1.charAt(i);
        char char2 = word2.charAt(j);
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == 0 && j == 0) {
            if (char1 == char2) {
                dp[i][j] = 0;
            } else {
                dp[i][j] = 1;
            }
        } else if (i == 0) {
            if (char1 == char2) {
                dp[i][j] = j;
            } else {
                dp[i][j] = dp(word1, word2, dp, i, j - 1) + 1;
            }
        } else if (j == 0) {
            if (char1 == char2) {
                dp[i][j] = i;
            } else {
                dp[i][j] = dp(word1, word2, dp, i - 1, j) + 1;
            }
        } else {
            if (char1 == char2) {
                dp[i][j] = dp(word1, word2, dp, i - 1, j - 1);
            } else {
                dp[i][j] = Math.min(dp(word1, word2, dp, i - 1, j) + 1, dp(word1, word2, dp, i, j - 1) + 1);
                dp[i][j] = Math.min(dp[i][j], dp(word1, word2, dp, i - 1, j - 1) + 1);
            }
        }
        return dp[i][j];
    }
}

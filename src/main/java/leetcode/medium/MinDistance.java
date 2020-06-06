package leetcode.medium;

/**
 * @Author long
 * @Date 2020/4/6 11:28
 * @Title 583. 两个字符串的删除操作
 * @Description //TODO
 **/

public class MinDistance {
    public static void main(String[] args) {
        minDistance("", "a");
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            dp[0] = i + 1;   //初始化，这里保存的是当前状态
            int prev = i; //初始化,关键 ：这里是i,因为保存的是上一步的状态
            for (int j = 0; j < m; j++) {
                int temp = dp[j + 1];
                if (word1.charAt(j) == word2.charAt(i)) {
                    dp[j + 1] = prev;
                } else {
                    dp[j + 1] = Math.min(dp[j + 1], dp[j]) + 1;
                }
                prev = temp;
            }
        }
        return dp[m];
    }
}

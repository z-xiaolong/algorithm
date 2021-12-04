package leetcode.hard;

/**
 * @Author long
 * @Date 2021/11/11 10:06
 * @Title
 * @Description //TODO
 **/

public class kInversePairs {

    //dp[i][j] = dp[i-1][j] + dp[i-1][j-1]+..+dp[i-1][j-k] (i-1 > j-k && i-1>=k)

    public static void main(String[] args) {
        kInversePairs k = new kInversePairs();
        k.kInversePairs(10, 8);
    }

    int mod = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        if (k == 0) return 1;
        if (n == 2) {
            if (k == 1) return 1;
            else return 0;
        }
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i && j <= k; j++) {
                for (int l = 0; l <= i - 1 && l <= j; l++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % mod;
                }
            }
        }
        return dp[n][k] % mod;
    }


}

package exam;

import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/8/25 18:56
 * @Title
 * @Description:
 */
public class DongFang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] res = new int[n];
        int count = 0;
        int[][] dp = new int[100][n + 1];
        int left = 1;
        int i = 0;
        int j = 0;
        while (count != k) {
            int c = dp(dp, i, n, 0);
            if (c < k) {
                count += c;
                i++;
            } else {
                res[j] = i;
                j++;
            }
        }
        for (int l = 0; l < res.length; l++) {
            System.out.print(l + " ");
        }
    }

    public static int dp(int[][] dp, int i, int j, int last) {
        if (dp[i][j] != 0) return dp[i][j];
        int count = 0;
        for (int k = last + 1; k < 100; k++) {
            count += dp(dp, k, j - 1, i);
        }
        dp[i][j] = count;
        return count;
    }


    public static void dp() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coins = new int[]{0, 20, 10, 5, 2, 1};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[n]);
    }

}

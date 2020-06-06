package leetcode.swordOffer.hard;

/**
 * @Author long
 * @Date 2020/4/11 9:37
 * @Title 887. 鸡蛋掉落
 * @Description //TODO
 **/

public class SuperEggDrop {
    public static void main(String[] args) {
        superEggDrop(2, 2);
    }

    public static int superEggDrop(int K, int N) {
        if (K == 1 || N <= 2) return N;
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
            dp[i][2] = 2;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 3; j <= N; j++) {
                int mid = j / 2;
                dp[i][j] = Math.max(dp[i][j - mid], dp[i - 1][mid - 1]) + 1;
            }
        }
        return dp[K][N] - 1;
    }

    int[][] dp;

    //动态规划+二分: 执行用时 :65 ms, 在所有 Java 提交中击败了29.38%的用户
    public int superEggDrop2(int K, int N) {
        dp = new int[K + 1][N + 1];
        return dp2(K, N);
    }

    public int dp2(int K, int N) {
        if (dp[K][N] != 0) {
            return dp[K][N];
        }
        if (K == 1 || N <= 2) {
            dp[K][N] = N;
            return N;
        }
        dp[K][N] = N;
        int high = N;
        int low = 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            int broken = dp2(K - 1, mid - 1);
            int notBroken = dp2(K, N - mid);
            if (broken > notBroken) {
                high = mid - 1;
                dp[K][N] = Math.min(dp[K][N], broken + 1);
            } else {
                low = mid + 1;
                dp[K][N] = Math.min(dp[K][N], notBroken + 1);
            }
        }
        return dp[K][N];
    }
}

package leetcode.hard;

/**
 * @Author long
 * @Date 2021/4/29 20:24
 * @Title
 * @Description //TODO
 **/

public class CanCross {
    public static void main(String[] args) {
        int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        canCross(stones);
    }

    public static boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 1; i < n; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k] || dp[j][k - 1] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * dp[i][k] = dp[i-1][k+1] || dp[i-1][k-1] || dp[i-1][k]
 */

package leetcode.medium;

/**
 * @Author long
 * @Date 2021/10/9 10:38
 * @Title
 * @Description //TODO
 **/
//1 2 3 4 5 6 7 8 9 10 == 16
public class GetMoneyAmount {

    public static void main(String[] args) {
        getMoneyAmount(10);
    }

    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 1; len < n; len++) {
            for (int start = 1; start + len <= n; start++) {
                int min = Integer.MAX_VALUE;
                for (int pivot = start; pivot < start + len; pivot++) {
                    int tmp = pivot + Math.max(dp[start][pivot - 1], dp[pivot + 1][start + len]);
                    min = Math.min(min, tmp);
                }
                dp[start][start + len] = min;
            }
        }
        return dp[1][n];
    }
}

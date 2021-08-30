package leetcode.medium;

/**
 * @Author long
 * @Date 2021/8/9 11:05
 * @Title
 * @Description //TODO
 **/

public class NthSuperUglyNumber {
    public static void main(String[] args) {
        int[] primes = new int[]{2, 7, 13, 19};
        nthSuperUglyNumber(12, primes);
    }



    public static int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] count = new int[k];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                dp[i] = Math.min(dp[i], dp[count[j]] * primes[j]);
            }
            for (int j = 0; j < k; j++) {
                if (dp[i] == dp[count[j]] * primes[j]) {
                    count[j]++;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}

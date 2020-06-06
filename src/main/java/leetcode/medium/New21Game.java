package leetcode.medium;

/**
 * @Author long
 * @Date 2020/6/3 9:04
 * @Title 837. 新21点
 * @Description //TODO
 **/

public class New21Game {

    private int N;
    private int K;
    private int W;

    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1.0d;
        double[] dp = new double[K + W + 1];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0d;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W; //初始值
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + (dp[i + 1] - dp[i + W + 1]) / W;
        }
        return dp[0];
    }

    public double dp(int i, double[] dp) {
        if (i >= K) return 1.0d;
        if (dp[i] != 0.0d) return dp[i];
        double rate = 1.0d / (double) W;
        double sum = 0.0d;
        for (int j = 1; j <= W; j++) {
            if (i + j > N) break;
            if (i + j >= K) sum += rate;
            else sum += dp(i + j, dp) * rate;
        }
        dp[i] = sum;
        return sum;
    }
}

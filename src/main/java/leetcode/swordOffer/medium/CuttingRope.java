package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/3/21 11:26
 * @Title 面试题14- I. 剪绳子
 * @Description //TODO
 **/

public class CuttingRope {

    public static void main(String[] args) {
        cuttingRopeI(4);
    }

    //执行用时 :执行用时 :1 ms, 在所有 Java 提交中击败了44.60%的用户
    public static int cuttingRopeI(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                int temp = Math.max(dp[i - j] * j, (i - j) * j);
                dp[i] = Math.max(dp[i], temp);
            }
        }
        return dp[n];
    }


    //面试题14- II. 剪绳子 II
    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int cuttingRopeII(int n) {
        int length = n;
        if (n < 7) {
            length = 7;
        }
        long[] dp = new long[length + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for (int i = 7; i <= length; i++) {
            dp[i] = (dp[i - 3] * 3) % 1000000007;
        }
        return (int) (dp[n] % 1000000007);
    }
}

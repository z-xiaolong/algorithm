package leetcode.hard;

/**
 * @Author long
 * @Date 2020/5/6 18:52
 * @Title LCP 09. 最小跳跃次数
 * @Description //TODO
 **/

public class MinJump {

    public int minJump(int[] jump) {
        return 0;
    }

    //执行用时 :13 ms, 在所有 Java 提交中击败了99.22%的用户
    public int minJumpI(int[] jump) {
        int n = jump.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (jump[i] + i >= n) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i + jump[i]] + 1;
            }
            for (int j = i + 1; j < n && dp[j] >= dp[i]+1; j++) {
                dp[j] = dp[i] + 1;
            }
        }
        return dp[0];
    }
}

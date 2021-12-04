package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/10/20 14:02
 * @Title
 * @Description //TODO
 **/

public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int avg = sum / k;
        int[] dp = new int[1 << n];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = sum;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0 && dp[i - (1 << j)] + nums[j] <= avg) {
                    dp[i] = (dp[i - (1 << j)] + nums[j]) % avg;
                    break;
                }
            }
        }
        return dp[dp.length - 1] == 0;
    }
}

package leetcode.medium.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/5/26 19:48
 * @Title 494. 目标和
 * @Description 01背包问题求方案数
 **/

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(S) || (sum + S) % 2 != 0) return 0;
        int target = (int) (sum + S) >> 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 0, -2, -3, 1};
        subarraysDivByK(arr, 5);
    }

    public static int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int count = 0;
        int sum = 0;
        for (int a : A) {
            sum += a;
            int mod = (sum % K + K) % K;
            count += map[mod];
            map[mod]++;
        }
        return count;
    }
}

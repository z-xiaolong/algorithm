package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/4/20 12:02
 * @Title 494. 目标和
 * @Description //TODO
 **/

public class FindTargetSumWays {




    //转化为01背包问题
    public int findTargetSumWays(int[] nums, int S) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((S + sum) % 2 == 1 || S > sum) {
            return 0;
        }
        S = (int) (S + sum) / 2; //******关键一步********
        //01背包问题，和为S
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = S; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[S];
    }


    //DP
    public int findTargetSumWaysIIII(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    int[][] dp;

    //备忘录DP：执行用时 :18 ms, 在所有 Java 提交中击败了58.28%的用户
    public int findTargetSumWaysIII(int[] nums, int S) {
        dp = new int[nums.length + 1][2001];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }
        return dp(nums, 0, S + 1000);
    }

    public int dp(int[] nums, int index, int S) {
        if (S < 0 || S > 2000) return 0;
        if (dp[index][S] != -1) return dp[index][S];
        if (index == nums.length) {
            if (S == 1000) dp[index][S] = 1;
            else dp[index][S] = 0;
        } else {
            dp[index][S] = dp(nums, index + 1, S + nums[index]) + dp(nums, index + 1, S - nums[index]);
        }
        return dp[index][S];
    }

    //递归: 执行用时 :632 ms, 在所有 Java 提交中击败了22.89%的用户
    public int findTargetSumWaysII(int[] nums, int S) {
        return subSum(nums, 0, S);
    }

    public int subSum(int[] nums, int index, int S) {
        if (index == nums.length) {
            if (S == 0) return 1;
            return 0;
        }
        int plus = subSum(nums, index + 1, S - nums[index]);
        int sub = subSum(nums, index + 1, S + nums[index]);
        return plus + sub;
    }

    private int max = 0;

    //回溯法：执行用时 :640 ms, 在所有 Java 提交中击败了21.93%的用户
    public int findTargetSumWaysI(int[] nums, int S) {
        backtrack(nums, S, 0, 0);
        return max;
    }

    public void backtrack(int[] nums, int S, int index, int sum) {
        if (index == nums.length) {
            if (sum == S) max++;
            return;
        }
        backtrack(nums, S, index + 1, sum + nums[index]);
        backtrack(nums, S, index + 1, sum - nums[index]);
    }
}

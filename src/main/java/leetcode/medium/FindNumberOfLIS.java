package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/9/20 10:20
 * @Title
 * @Description //TODO
 **/

public class FindNumberOfLIS {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        findNumberOfLIS(nums);
    }


    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        cnt[0] = 1;
        int max = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                ans = cnt[i];
            } else if (dp[i] == max) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    public static int findNumberOfLIS_DP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        cnt[0] = 1;
        int max = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                    cnt[i] += cnt[j];
                }
            }
            if (cnt[i] == 0) cnt[i] = 1;
            max = Math.max(dp[i], max);
        }

        for (int i = 0; i < n; i++) {
            if (dp[i] == max) ans += cnt[i];
        }
        return ans;
    }
}

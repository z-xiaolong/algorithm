package leetcode.hard;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/5/4 8:35
 * @Title 45. 跳跃游戏 II
 * @Description //TODO
 **/

public class Jump {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        Jump jump = new Jump();
        jump.jump(nums);
    }

    //贪心
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    //DP：执行用时 :351 ms, 在所有 Java 提交中击败了10.49%的用户
    public int jumpI(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int j = nums[i];
            int min = n;
            for (int k = 1; k <= j; k++) {
                if (i + k < n) min = Math.min(min, dp[i + k]);
                else break;
            }
            dp[i] = min + 1;
        }
        return dp[0];
    }

    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= n) return true;
            if (maxIndex == i) return false;
        }
        return true;
    }
}

package leetcode.medium.dp;

/**
 * @Author long
 * @Date 2020/5/26 19:37
 * @Title 416. 分割等和子集
 * @Description //TODO
 **/

public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int mid = sum >> 1;
        int[] dp = new int[mid + 1];
        for (int num : nums) {
            for (int i = mid; i >= num; i--) {
                dp[i] = Math.max(dp[i], dp[i - num] + num);
            }
        }
        return dp[mid] == mid;
    }
}

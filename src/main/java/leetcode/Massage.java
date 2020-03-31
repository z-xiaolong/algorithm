package leetcode;

/**
 * @Author long
 * @Date 2020/3/24 10:08
 * @Title 面试题 17.16. 按摩师
 * @Description //TODO
 **/

public class Massage {


    //动态规划，空间复杂度O(1): 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int massage(int[] nums) {
        int currentMax = 0;
        int preMax = 0;
        for (int num : nums) {
            int temp = currentMax;
            currentMax = preMax + num;
            preMax = Math.max(temp, preMax);
        }
        return Math.max(currentMax, preMax);
    }


    //动态规划，带dp数组： 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int massageI(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = nums[1];
        for (int i = 3; i < dp.length; i++) {
            dp[i] = nums[i - 1] + Math.max(dp[i - 2], dp[i - 3]);
        }
        return Math.max(dp[length], dp[length - 1]);
    }
}

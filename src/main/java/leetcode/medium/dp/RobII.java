package leetcode.medium.dp;

/**
 * @Author long
 * @Date 2020/2/19 16:12
 * @Title 213. 打家劫舍 II
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
 * 系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
 * 能够偷窃到的最高金额。
 **/

public class RobII {

    //分两种情况
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int currMax1 = nums[0];
        int prevMax1 = currMax1;
        for (int i = 2; i < nums.length - 1; i++) {
            int temp = currMax1;
            currMax1 = Math.max(prevMax1 + nums[i], currMax1);
            prevMax1 = temp;
        }
        int currMax2 = 0;
        int prevMax2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = currMax2;
            currMax2 = Math.max(prevMax2 + nums[i], currMax2);
            prevMax2 = temp;
        }
        return Math.max(currMax1, currMax2);
    }
}

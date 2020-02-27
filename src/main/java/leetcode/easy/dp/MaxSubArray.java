package leetcode.easy.dp;

/**
 * @Author long
 * @Date 2020/2/19 10:25
 * @Title 面试题42. 连续子数组的最大和
 * @Description 输入一个整型数组，数组里有正数也有负数。
 * 数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 **/

public class MaxSubArray {

    //动态规划
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            if (temp > 0) {
                temp = temp + num;
            } else {
                temp = num;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}

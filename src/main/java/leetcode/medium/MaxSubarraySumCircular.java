package leetcode.medium;

/**
 * @Author long
 * @Date 2021/10/27 16:54
 * @Title
 * @Description //TODO
 **/

public class MaxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE / 2;
        int min = Integer.MAX_VALUE / 2;
        int maxSum = Integer.MIN_VALUE / 2;
        int minSum = Integer.MAX_VALUE / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(num, maxSum + num);
            minSum = Math.min(num, minSum + num);
            max = Math.max(maxSum, max);
            min = Math.min(minSum, min);
        }
        return min == sum ? max : Math.max(max, sum - min);
    }
}

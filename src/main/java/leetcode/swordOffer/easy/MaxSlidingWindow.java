package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/7 10:46
 * @Title 面试题59 - I. 滑动窗口的最大值
 * @Description 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 **/

public class MaxSlidingWindow {

    //未完成
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int[] result = new int[nums.length - k];
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        result[0] = max;
        for (int i = k; i < nums.length; i++) {
            if (nums[k] > max) {
                result[i - k] = nums[k];
            }
        }
        return result;
    }
}

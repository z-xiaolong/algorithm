package leetcode.medium;

/**
 * @Author long
 * @Date 2020/5/2 9:17
 * @Title 209. 长度最小的子数组
 * @Description //TODO
 **/

public class MinSubArrayLen {

    //执行用时 :1 ms, 在所有 Java 提交中击败了99.98%的用户
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int sum = 0;
        int min = length + 1;
        int left = 0, right = 0;
        while (right < length) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min == length + 1 ? 0 : min;
    }
}

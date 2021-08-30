package leetcode.medium;

import java.util.LinkedList;

/**
 * @Author long
 * @Date 2021/2/22 10:11
 * @Title
 * @Description //TODO
 **/

public class LongestSubarray {


    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 4, 7, 2};
        longestSubarray(nums, 5);
    }

    public static int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ans = 1;
        LinkedList<Integer> min = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        for (; right < n; right++) {
            while (!max.isEmpty() && nums[right] >= nums[max.getLast()]) {
                max.pollLast();
            }
            max.addLast(right);
            while (!min.isEmpty() && nums[right] <= nums[min.getLast()]) {
                min.pollLast();
            }
            min.addLast(right);
            while (!max.isEmpty() && !min.isEmpty() && nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                if (max.peekFirst() > min.peekFirst()) {
                    left = min.pollFirst() + 1;
                } else {
                    left = max.pollFirst() + 1;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

package leetcode.easy;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2019/12/1 13:36
 * @Title 581. 最短无序连续子数组
 * @Description 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 **/

public class UnsortedSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4};
        System.out.println(findSubarray(nums));
    }


    /**
     * create by long on 2019/12/1
     * @description
     */
    public static int findSubarray(int[] nums) {
        int prev = 0;
        int next = nums.length - 1;
        while (prev < nums.length - 1 && nums[prev] <= nums[prev + 1]) {
            prev++;
        }
        if (prev == nums.length - 1) {
            return 0;
        }
        while (next > prev && nums[next] >= nums[next - 1]) {
            next--;
        }
        int min = nums[prev];
        int max = nums[next];
        for (int i = prev; i <= next; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        while (prev >= 0 && min < nums[prev]) {
            prev--;
        }
        while (next < nums.length && max > nums[next]) {
            next++;
        }
        return next - prev - 1;
    }


    /**
     * create by long on 2019/12/1
     *
     * @description 先排序，后比较
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int prev = 0;
        int next = nums.length - 1;
        while (prev <= next && temp[prev] == nums[prev]) {
            prev++;
        }
        while (next > prev && temp[next] == nums[next]) {
            next--;
        }
        return next - prev;
    }

}

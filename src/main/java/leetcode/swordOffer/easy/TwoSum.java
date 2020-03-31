package leetcode.swordOffer.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/14 20:43
 * @Title 面试题57. 和为s的两个数字
 * @Description 输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 **/

public class TwoSum {

    //有序数组，使用双指针：执行用时 :3 ms, 在所有 Java 提交中击败了61.42%的用户
    public int[] twoSumII(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length < 2) {
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }
        }
        return res;
    }


    //Hash：执行用时 :64 ms, 在所有 Java 提交中击败了11.61%的用户
    public int[] twoSumI(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length < 2) {
            return res;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            int sub = target - num;
            if (hashMap.containsKey(sub)) {
                res[0] = num;
                res[1] = sub;
                return res;
            }
            hashMap.put(num, 1);
        }
        return res;
    }
}

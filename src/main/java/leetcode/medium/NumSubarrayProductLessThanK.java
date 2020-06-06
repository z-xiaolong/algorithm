package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/5/15 10:57
 * @Title 713. 乘积小于K的子数组
 * @Description //TODO
 **/

public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0;
        int product = 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += i - left + 1;
        }
        return count;
    }
}

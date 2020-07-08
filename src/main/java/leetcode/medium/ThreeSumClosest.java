package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/6/24 9:50
 * @Title
 * @Description //TODO
 **/

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int left;
        int right;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    right--;
                    if (sum - target < Math.abs(res - target))
                        res = sum;
                } else if (sum < target) {
                    left++;
                    if (target - sum < Math.abs(res - target))
                        res = sum;
                } else {
                    return target;
                }
            }
        }
        return res;
    }
}

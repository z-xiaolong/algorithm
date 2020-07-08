package leetcode.byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author long
 * @Date 2020/6/24 10:18
 * @Title
 * @Description //TODO
 **/

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
                if (sum > target) {
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else {
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        return output;
    }
}

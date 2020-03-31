package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 21:22 2019/11/12
 * @Title 两数之和
 * @Description 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 **/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == temp) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public int[] twoSum_two(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            int tmp = nums[i];
            int pairValue = target - tmp;
            if (numMap.containsKey(pairValue)) {
                return new int[]{i, numMap.get(pairValue)};
            }
            numMap.put(tmp, i);
        }
        return new int[0];
    }

}

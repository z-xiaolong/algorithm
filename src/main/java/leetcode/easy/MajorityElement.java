package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 20:18 2019/10/20
 * @Title
 * @Description 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊n/2⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 **/

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int count = 1;
        int majority = nums[0];
        Map<Integer, Integer> map = new HashMap<>(nums.length / 2);
        for (int num : nums) {
            if (map.containsKey(num)) {
                int value = map.get(num) + 1;
                map.put(num, value);
                if (value > count) {
                    count = value;
                    majority = num;
                }
            } else {
                map.put(num, 1);
            }
        }
        return majority;
    }

    public static int majorityElementII(int[] nums) {
        int majority = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
            }
            if (num == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}

package leetcode.hard;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/12 11:34
 * @Title
 * @Description //TODO
 **/

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum.threeSum(nums);
    }

    //执行用时 :29 ms, 在所有 Java 提交中击败了86.14%的用户
    //优化后：执行用时 :21 ms, 在所有 Java 提交中击败了98.96%的用户
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> output = new LinkedList<>();
        if (length < 3) {
            return output;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    output.add(Arrays.asList(-target, nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return output;
    }

    public void findSum(List<List<Integer>> output, int[] nums, int index, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(nums.length - index);
        for (int i = index + 1; i < nums.length; ++i) {
            int tmp = nums[i];
            int pairValue = target - tmp;
            if (numMap.containsKey(pairValue)) {
                List<Integer> list = new ArrayList<>(3);
                list.add(-target);
                list.add(nums[i]);
                list.add(pairValue);
                output.add(list);
            }
            numMap.put(tmp, i);
        }
    }
}

package leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/5/3 7:49
 * @Title 697. 数组的度
 * @Description //TODO
 **/

public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(),
                right = new HashMap<>(),
                count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!left.containsKey(nums[i])) left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int res = nums.length;
        int degree = Collections.max(count.values());
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                res = Math.min(res, right.get(num) - left.get(num) + 1);
            }
        }
        return res;
    }
}

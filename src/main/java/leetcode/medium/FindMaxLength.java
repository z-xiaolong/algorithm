package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/5/15 9:47
 * @Title 525. 连续数组
 * @Description //TODO
 **/

public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int max = 0;
        int one = 0;
        hashMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) one++;
            else one--;
            if (hashMap.containsKey(one)) {
                int index = hashMap.get(one);
                max = Math.max(max, i - index);
            } else {
                hashMap.put(one, i);
            }
        }
        return max;
    }
}

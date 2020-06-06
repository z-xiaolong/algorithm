package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/5/15 10:28
 * @Title 523. 连续的子数组和
 * @Description //TODO
 **/

public class CheckSubarraySum {

    public static void main(String[] args) {
        CheckSubarraySum checkSubarraySum = new CheckSubarraySum();
        int[] nums = new int[]{23, 2, 4, 6, 7};
        checkSubarraySum.checkSubarraySum(nums, -6);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (hashMap.containsKey(sum)) {
                if (i - hashMap.get(sum) > 1) return true;
            } else {
                hashMap.put(sum, i);
            }
        }
        return false;
    }
}

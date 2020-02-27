package leetcode.medium;

import java.util.HashMap;

/**
 * @Author long
 * @Date 2020/2/23 17:19
 * @Title 560. 和为K的子数组
 * @Description 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 **/

public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 7, 2, -3, 1, 4, 2};
        subarraySum(nums, 7);
    }


    //哈希,复杂度 n, 前缀和
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        int[] sum = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= length; i++) {
            for (int j = i + 1; j <= length + 1; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //暴力法，复杂度 n^2
    public static int subarraySum1(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = left;
        int sum = 0;
        int count = 0;
        while (left < length) {
            while (right < length) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
                right++;
            }
            left++;
            right = left;
            sum = 0;
        }
        return count;
    }
}

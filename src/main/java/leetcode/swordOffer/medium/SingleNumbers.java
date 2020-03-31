package leetcode.swordOffer.medium;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/23 11:40
 * @Title 面试题56 - I. 数组中数字出现的次数
 * @Description 要求时间复杂度是O(n)，空间复杂度是O(1)。
 **/

public class SingleNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 5, 5, 9, 9};
        singleNumbers(nums);
    }

    public static int[] singleNumbers(int[] nums) {
        int xorNumber = nums[0];
        for (int k = 1; k < nums.length; k++) {
            xorNumber ^= nums[k];
        }
        int onePosition = xorNumber & (-xorNumber);
        int ans1 = 0, ans2 = 0;
        for (int num : nums) {
            if ((num & onePosition) == onePosition) {
                ans1 ^= num;
            } else {
                ans2 ^= num;
            }
        }
        return new int[]{ans1, ans2};
    }

    public int[] singleNumbersII(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0) x ^= num;
        }
        return new int[]{x, bitmask ^ x};
    }

    //Hash：执行用时 :13 ms, 在所有 Java 提交中击败了17.49%的用户
    public int[] singleNumbersI(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}

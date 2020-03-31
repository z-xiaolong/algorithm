package leetcode.swordOffer.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/20 10:03
 * @Title 面试题56 - II. 数组中数字出现的次数 II
 * @Description //TODO
 **/

public class SingleNumber {

    //官方最佳解
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }

    //暴力解：hash  执行用时 :16 ms, 在所有 Java 提交中击败了56.25%的用户
    public int singleNumberI(int[] nums) {
        int size = nums.length / 3 + 1;
        Map<Integer, Integer> hashMap = new HashMap<>(size);
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}

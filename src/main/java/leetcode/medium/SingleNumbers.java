package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/4/28 11:16
 * @Title 面试题56 - I. 数组中数字出现的次数
 * @Description //TODO
 **/

public class SingleNumbers {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(-8));
    }

    //执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int diff = xor & (-xor);
        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                x ^= num;
            }
        }
        return new int[]{x, x ^ xor};
    }

    //空间复杂度为O(n):执行用时 :17 ms, 在所有 Java 提交中击败了8.88%的用户
    public int[] singleNumbersI(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] res = new int[2];
        int i = 0;
        for (int num : set) {
            res[i] = num;
            i++;
        }
        return res;
    }
}

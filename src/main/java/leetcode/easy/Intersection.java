package leetcode.easy;

import java.util.*;

/**
 * @Author long
 * @Date 2020/4/27 10:45
 * @Title 349. 两个数组的交集
 * @Description //TODO
 **/

public class Intersection {

    //hash：执行用时 :4 ms, 在所有 Java 提交中击败了66.02%的用户
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                hashSet.add(num);
            }
        }
        int[] res = new int[hashSet.size()];
        int i = 0;
        for (int num : hashSet) {
            res[i] = num;
            i++;
        }
        return res;
    }
}

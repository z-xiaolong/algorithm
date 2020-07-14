package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/7/13 9:26
 * @Title 350. 两个数组的交集 II
 * @Description //TODO
 **/

public class Intersect {


    //执行用时：4 ms, 在所有 Java 提交中击败了57.14%的用户
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 0);
            }
            hashMap.put(num, hashMap.get(num) + 1);
        }
        for (int num : nums2) {
            if (hashMap.containsKey(num) && hashMap.get(num) > 0) {
                list.add(num);
                hashMap.put(num, hashMap.get(num) - 1);
            }
        }
        //return list.stream().mapToInt((a -> a)).toArray();
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

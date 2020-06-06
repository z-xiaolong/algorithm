package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/5/30 11:05
 * @Title 496. 下一个更大元素 I
 * @Description //TODO
 **/

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        if (n == 0) return new int[0];
        int[] res = new int[n];
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

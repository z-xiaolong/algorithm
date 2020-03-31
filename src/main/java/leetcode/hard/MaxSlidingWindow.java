package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author long
 * @Date 2020/3/7 20:19
 * @Title 239. 滑动窗口最大值
 * @Description //TODO
 **/

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        maxSlidingWindow(nums, 3);
    }


    //双向队列  执行用时 :12 ms, 在所有 Java 提交中击败了77.49%的用户
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return new int[0];
        }
        int[] res = new int[length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(length);
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        for (int i = 0; i < res.length - 1; i++) {
            res[i] = deque.peekFirst();
            if (nums[i] == res[i]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i + k] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i + k]);
        }
        res[res.length - 1] = deque.peekFirst();
        return res;
    }


    //执行用时为 1 ms 的范例
    public int[] maxSlidingWindowII(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            if (i < maxIndex && maxIndex < i + k) {
                if (max <= nums[i + k - 1]) {
                    max = nums[i + k - 1];
                    maxIndex = i + k - 1;
                }
            } else {
                max = nums[i];
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }

    //动态规划 执行用时 :3 ms, 在所有 Java 提交中击败了93.79%的用户
    public static int[] maxSlidingWindowI(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return null;
        }
        int[] left = new int[length];
        int[] right = new int[length];
        int[] res = new int[length - k + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (i % k == 0) {
                max = Integer.MIN_VALUE;
            }
            left[i] = Math.max(nums[i], max);
            max = left[i];
        }
        max = Integer.MIN_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            if ((i + 1) % k == 0) {
                max = Integer.MIN_VALUE;
            }
            right[i] = Math.max(nums[i], max);
            max = right[i];
        }
        for (int i = 0, j = k - 1; i < res.length && j < length; i++, j++) {
            res[i] = Math.max(left[j], right[i]);
        }
        return res;
    }
}

package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2020/7/5 15:28
 * @Title
 * @Description //TODO
 **/

public class MinInteger {


    public String minInteger(String num, int k) {
        char[] nums = num.toCharArray();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> nums[o]));

        int i = 0;
        for (int j = 0; j < nums.length && j < k; j++) {
            queue.add(j);
        }
        int step = 0;
        while (k > 0 && i < nums.length) {
            while (queue.peek() + step > k) queue.poll();
            int min = queue.poll() + step;
            k = swap(nums, min, k, i);
            i++;
            step++;
        }
        return new String(nums);
    }


    public int swap(char[] nums, int min, int k, int i) {
        char value = nums[min];
        int j = min;
        while (j > i) {
            nums[j] = nums[j - 1];
            j--;
        }
        nums[i] = value;
        return k - (min - i);
    }
}

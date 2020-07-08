package leetcode.byteDance;

import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2020/6/24 10:34
 * @Title
 * @Description //TODO
 **/

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}















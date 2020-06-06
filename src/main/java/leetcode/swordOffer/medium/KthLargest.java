package leetcode.swordOffer.medium;

import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2020/4/8 17:25
 * @Title
 * @Description //TODO
 **/

public class KthLargest {

    private int Kth;
    private PriorityQueue<Integer> priorityQueue;

    public KthLargest(int k, int[] nums) {
        this.Kth = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
    }

    public int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > Kth) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}

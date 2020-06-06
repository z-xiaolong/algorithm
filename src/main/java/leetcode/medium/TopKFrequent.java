package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2019/10/13 18:55
 * @Description 347.前 K 个高频元素：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class TopKFrequent {


    //执行用时 :16 ms, 在所有 Java 提交中击败了87.73%的用户
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            priorityQueue.add(new int[]{key, value});
        }
        while (list.size() < k) {
            list.add(priorityQueue.poll()[0]);
        }
        return list;
    }
}

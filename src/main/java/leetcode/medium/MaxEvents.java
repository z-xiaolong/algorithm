package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/5/5 9:51
 * @Title 1353. 最多可以参加的会议数目
 * @Description //TODO
 **/

public class MaxEvents {


    //执行用时 :122 ms, 在所有 Java 提交中击败了14.07%的用户
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int days = 0;
        for (int[] event : events) {
            days = Math.max(days, event[1]);
        }
        int n = events.length;
        int res = 0;
        int i = 1;
        int j = 0;
        while (i < days) {
            while (j < n && i == events[j][0]) {
                priorityQueue.add(events[j]);
                j++;
            }
            if (!priorityQueue.isEmpty()) {
                priorityQueue.poll();
                res++;
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] <= i) {
                priorityQueue.poll();
            }
            i++;
        }
        return res;
    }

    //复杂度：O(n^2) 超时
    public int maxEventsI(int[][] events) {
        Arrays.sort(events, (o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            for (int i = start; i <= end; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}

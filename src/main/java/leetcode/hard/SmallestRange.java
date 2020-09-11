package leetcode.hard;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: long
 * @Date: 2020/8/1 9:00
 * @Title 632. 最小区间
 * @Description:
 */
public class SmallestRange {

    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int[][] indicates = new int[n][2];
        int[] res = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        PriorityQueue<int[]> max = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o[0]).get(o[1])));
        PriorityQueue<int[]> min = new PriorityQueue<>((o1, o2) -> nums.get(o2[0]).get(o2[1]) - nums.get(o1[0]).get(o1[1]));
        for (int i = 0; i < n; i++) {
            indicates[i][0] = i;
            indicates[i][1] = 0;
            max.add(indicates[i]);
            min.add(indicates[i]);
        }
        while (nums.get(min.peek()[0]).size() > min.peek()[1]) {

            int maxNum = nums.get(max.peek()[0]).get(max.peek()[1]);
            int minNum = nums.get(min.peek()[0]).get(min.peek()[1]);
            if (maxNum - minNum < res[1] - res[0]) {
                res[1] = maxNum;
                res[0] = minNum;
            }
            int[] indicate = min.poll();
            if (nums.get(indicate[0]).size() > ++indicate[1]) {
                min.add(indicate);
            } else {
                break;
            }
        }
        return res;
    }
}

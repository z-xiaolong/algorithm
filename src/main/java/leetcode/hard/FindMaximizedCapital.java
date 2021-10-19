package leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2021/9/8 9:51
 * @Title
 * @Description //TODO
 **/

public class FindMaximizedCapital {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        boolean speedFlag = true;
        for (int c : capital) {
            if (w < c) {
                speedFlag = false;
                break;
            }
        }
        if (speedFlag) {
            PriorityQueue<Integer> profitsQueue = new PriorityQueue<>();
            for (int p : profits) {
                profitsQueue.add(p);
                if (profitsQueue.size() > k) {
                    profitsQueue.poll();
                }
            }
            for (int p : profitsQueue) {
                w += p;
            }
            return w;
        }
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = capital[i];
            data[i][1] = profits[i];
        }
        Arrays.sort(data, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < n && data[j][0] <= w) {
                queue.add(data[j][1]);
                j++;
            }
            if (queue.isEmpty()) return w;
            w += queue.poll();
        }
        return w;
    }
}

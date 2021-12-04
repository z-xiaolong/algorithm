package leetcode.hard;

import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2021/11/29 19:55
 * @Title
 * @Description //TODO
 **/

public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] * b[0] - a[0] * b[1]);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                queue.offer(new int[]{arr[i], arr[j]});
                if (queue.size() > k) {
                    int[] top = queue.poll();
                    if (top[0] == arr[i] && top[1] == arr[j]) break;
                }
            }
        }
        int[] top = queue.poll();
        return new int[]{top[0], top[1]};
    }

}

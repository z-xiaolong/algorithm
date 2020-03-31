package leetcode.favorite;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2020/3/15 14:19
 * @Title 5359. 最大的团队表现值   贪心算法，排序
 * @Description
 **/

public class MaxPerformance {

    public static void main(String[] args) {
        int[] speed = new int[]{2, 10, 3, 1, 5, 8};
        int[] efficiency = new int[]{5, 4, 3, 9, 7, 2};
        maxPerformance(6, speed, efficiency, 2);
    }

    //参考解：执行用时 :58 ms, 在所有 Java 提交中击败了100.00%的用户
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        //Arrays.sort(items, (a, b) -> b[1] - a[1]); lambda 表达式
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long res = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            queue.add(items[i][0]);
            sum += items[i][0];
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            res = Math.max(res, sum * items[i][1]);
        }
        return (int) (res % ((int) 1e9 + 7));
    }
}

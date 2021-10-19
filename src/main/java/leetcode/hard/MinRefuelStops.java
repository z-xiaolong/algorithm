package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2021/10/18 19:14
 * @Title
 * @Description //TODO
 **/

public class MinRefuelStops {

    public static void main(String[] args) {
        int[] heights = new int[]{14,3,19,3};
        furthestBuilding(heights, 17, 0);
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        int i = 0;
        for (; i < n - 1; i++) {
            int sub = heights[i + 1] - heights[i];
            if (sub > 0) {
                queue.add(sub);
                if (queue.size() > ladders) {
                    bricks -= queue.poll();
                    if (bricks < 0) break;
                }
            }
        }
        return i;
    }

    public static int eatenApples(int[] apples, int[] days) {
        int n = days.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        for (int i = 0; i < n || !queue.isEmpty(); i++) {
            while (!queue.isEmpty() && (queue.peek()[1] <= i || queue.peek()[0] < 1)) {
                queue.poll();
            }
            if (i < n && apples[i] > 0) queue.add(new int[]{apples[i], i + days[i]});
            if (!queue.isEmpty() && queue.peek()[0] > 0) {
                queue.peek()[0]--;
                ans++;
            }
        }
        return ans;
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int ans = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int[] station : stations) {
            while (startFuel < station[0]) {
                if (queue.isEmpty()) return -1;
                startFuel += queue.poll()[1];
                ans++;
            }
            queue.add(station);
        }
        while (startFuel < target && !queue.isEmpty()) {
            startFuel += queue.poll()[1];
            ans++;
        }
        if (startFuel < target) return -1;
        return ans;
    }


}

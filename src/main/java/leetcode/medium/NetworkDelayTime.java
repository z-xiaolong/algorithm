package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2021/9/18 16:11
 * @Title
 * @Description //TODO
 **/

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[k] = 0;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        queue.add(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            List<int[]> next = graph.get(node[0]);
            if (dp[node[0]] < node[1]) continue;
            for (int[] nextNode : next) {
                if (dp[nextNode[0]] > dp[node[0]] + nextNode[1]) {
                    dp[nextNode[0]] = dp[node[0]] + nextNode[1];
                    queue.add(new int[]{nextNode[0], dp[nextNode[0]]});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; ++i) {
            max = Math.max(max, dp[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

}

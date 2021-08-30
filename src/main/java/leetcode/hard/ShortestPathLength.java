package leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2021/8/6 11:40
 * @Title
 * @Description //TODO
 **/

public class ShortestPathLength {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0];
            int mask = tuple[1];
            int dist = tuple[2];
            if (mask == (1 << n) - 1) {
                return dist;
            }
            for (int v : graph[u]) {
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return 0;
    }
}

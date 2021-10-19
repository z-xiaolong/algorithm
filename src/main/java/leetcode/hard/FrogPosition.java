package leetcode.hard;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/8 14:13
 * @Title 5355. T 秒后青蛙的位置
 * @Description //TODO
 **/

public class FrogPosition {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{2, 1}, {3, 2}};
        frogPosition(3, edges, 1, 2);
    }

    public static double frogPosition(int n, int[][] edges, int t, int target) {
        double[] dp = new double[n + 1];
        boolean[] visited = new boolean[n + 1];
        List<Set<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edg : edges) {
            tree.get(edg[0]).add(edg[1]);
            tree.get(edg[1]).add(edg[0]);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;
        dp[1] = 1.0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            Set<Integer> child = tree.get(node[0]);
            int size = node[0] == 1 ? child.size() : child.size() - 1;
            if (size > 0 && node[0] == target && node[1] < t) return 0.0;
            if (size == 0 || node[1] == t) continue;
            for (int c : child) {
                dp[c] = dp[node[0]] / size;
                if (!visited[c]) {
                    queue.add(new int[]{c, node[1] + 1});
                    visited[c] = true;
                }
            }
        }
        return dp[target];
    }
}

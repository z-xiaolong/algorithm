package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/11/15 21:25
 * @Title
 * @Description //TODO
 **/

public class SumOfDistancesInTree {
    int[] res;
    int[] dp;
    int[] child;
    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        res = new int[N];
        dp = new int[N];
        child = new int[N];
        graph = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int u, int v) {
        child[u] = 1;
        dp[u] = 0;
        for (int k : graph.get(u)) {
            if (k == v) continue;
            dfs(k, u);
            dp[u] += dp[k] + child[k];
            child[u] += child[k];
        }
    }

    public void dfs2(int u, int v) {
        res[u] = dp[u];
        for (int k : graph.get(u)) {
            if (k == v) continue;

            int dpU = dp[u];
            int childU = child[u];
            int dpK = dp[k];
            int childK = child[k];

            dp[u] -= dp[k] + child[k];
            child[u] -= child[k];
            dp[k] += dp[u] + child[u];
            child[k] += child[u];

            dfs2(k, u);

            dp[u] = dpU;
            child[u] = childU;
            dp[k] = dpK;
            child[k] = childK;
        }
    }


}

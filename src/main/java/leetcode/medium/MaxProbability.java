package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2021/9/18 10:18
 * @Title
 * @Description //TODO
 **/

public class MaxProbability {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = new double[]{0.5, 0.5, 0.2};
        maxProbability(3, edges, succProb, 0, 2);
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<double[]>> graph = new ArrayList<>();
        double[] dp = new double[n];
        dp[start] = 1.0;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edg = edges[i];
            graph.get(edg[0]).add(new double[]{edg[1], succProb[i]});
            graph.get(edg[1]).add(new double[]{edg[0], succProb[i]});
        }
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                if (a[0] == b[0]) return 0;
                return a[0] > b[0] ? -1 : 1;
            } else return a[1] > b[1] ? -1 : 1;
        });

        queue.add(new double[]{start, 1.0});
        while (!queue.isEmpty()) {
            double[] node = queue.poll();
            if (dp[(int) node[0]] < node[1]) continue;
            List<double[]> next = graph.get((int) node[0]);
            for (double[] nextNode : next) {
                if (dp[(int) nextNode[0]] < dp[(int) node[0]] * nextNode[1]) {
                    dp[(int) nextNode[0]] = dp[(int) node[0]] * nextNode[1];
                    queue.add(new double[]{(int) nextNode[0], dp[(int) nextNode[0]]});
                }
            }
        }
        return dp[end];
    }


}

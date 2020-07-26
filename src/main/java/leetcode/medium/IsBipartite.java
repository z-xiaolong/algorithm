package leetcode.medium;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/7/16 16:03
 * @Title 785. 判断二分图
 * @Description //TODO
 **/

public class IsBipartite {




    //DFS
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int v, int color, int[] visited) {
        if (visited[v] != 0) {
            return visited[v] == color;
        }
        visited[v] = color;
        for (int w : graph[v]) {
            if (!dfs(graph, w, -color, visited))
                return false;
        }
        return true;
    }


    //BFS
    public boolean isBipartiteI(int[][] graph) {
        int n = graph.length;
        int[] isVisited = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (isVisited[i] != 0) continue;
            queue.offer(i);
            isVisited[i] = 1;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int w : graph[node]) {
                    if (isVisited[node] == isVisited[w])
                        return false;
                    if (isVisited[w] == 0) {
                        isVisited[w] = -isVisited[node];
                        queue.offer(w);
                    }
                }

            }
        }
        return true;
    }

}

package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/8/6 10:19
 * @Title
 * @Description //TODO
 **/

public class EventualSafeNodes {


    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] flag = new int[n]; // 0未访问过 -1环内 1可终止
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(graph, flag, i)) {
                res.add(i);
            }
        }
        return res;
    }


    public boolean dfs(int[][] graph, int[] flag, int index) {
        if (flag[index] > 0) {
            return flag[index] == 2;
        }
        flag[index] = 1;
        for (int node : graph[index]) {
            if (!dfs(graph, flag, node)) {
                return false;
            }
        }
        flag[index] = 2;
        return true;
    }
}

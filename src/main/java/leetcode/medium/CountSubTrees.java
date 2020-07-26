package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/7/20 10:01
 * @Title
 * @Description //TODO
 **/

public class CountSubTrees {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] points = new List[n];
        for (int i = 0; i < n; i++) {
            points[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            points[edge[0]].add(edge[1]);
            points[edge[1]].add(edge[0]);
        }
        int[] res = new int[n];
        boolean[] visited = new boolean[n];
        dfs(points, labels, res, 0, visited);
        return res;
    }

    public int[] dfs(List<Integer>[] points, String labels, int[] res, int index, boolean[] visited) {
        int[] map = new int[26];
        List<Integer> list = points[index];
        char c = labels.charAt(index);
        visited[index] = true;
        for (int i : list) {
            if (!visited[i]) {
                int[] temp = dfs(points, labels, res, i, visited);
                for (int j = 0; j < temp.length; j++) {
                    map[j] += temp[j];
                }
            }
        }
        map[c - 'a']++;
        res[index] = map[c - 'a'];
        return map;
    }
}

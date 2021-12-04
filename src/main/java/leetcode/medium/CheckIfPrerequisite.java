package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2021/11/18 21:19
 * @Title
 * @Description //TODO
 **/

public class CheckIfPrerequisite {

    //  1 -> 2
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Set<Integer>[] courses = new Set[n];
        Set<Integer>[] query = new Set[n];
        for (int i = 0; i < n; i++) {
            courses[i] = new HashSet<>();
            query[i] = new HashSet<>();
        }
        int[] degree = new int[n];
        for (int[] p : prerequisites) {
            courses[p[1]].add(p[0]);
            degree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int next : courses[index]) {
                degree[next]--;
                if (degree[next] == 0) queue.add(next);
                query[next].addAll(query[index]);
                query[next].add(index);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(query[q[0]].contains(q[1]));
        }
        return ans;
    }
}

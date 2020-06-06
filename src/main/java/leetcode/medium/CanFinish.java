package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/5/17 8:38
 * @Title 207. 课程表
 * @Description //TODO
 **/

public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> adjacency = new ArrayList<>(numCourses);
        int[] inDegrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[1]]++;
            adjacency.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            Set<Integer> set = adjacency.get(node);
            for (int i : set) {
                inDegrees[i]--;
                if (inDegrees[i] == 0) queue.add(i);
            }
            numCourses--;
        }
        return numCourses == 0;
    }
}

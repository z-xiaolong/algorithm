package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/5/17 8:01
 * @Title 210. 课程表 II
 * @Description //TODO
 **/

public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<Set<Integer>> adjacency = new ArrayList<>(numCourses);
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
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int j : adjacency.get(index)) {
                inDegrees[j]--;
                if (inDegrees[j] == 0) queue.add(j);
            }
            order[numCourses--] = index;
        }
        if (numCourses != 0) return new int[0];
        return order;
    }
}

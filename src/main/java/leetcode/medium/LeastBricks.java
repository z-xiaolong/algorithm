package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2021/5/2 20:25
 * @Title
 * @Description //TODO
 **/

public class LeastBricks {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = wall.size();
        int max = 0;
        for (List<Integer> w : wall) {
            int sum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        return n - max;
    }

    public int getImportance(List<Employee> employees, int id) {
        int importance = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        while (!queue.isEmpty()) {
            Employee e = map.get(queue.poll());
            importance += e.importance;
            queue.addAll(e.subordinates);
        }
        return importance;
    }


    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    ;
}

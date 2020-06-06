package leetcode.medium.greedy;

import java.util.*;

/**
 * @Author long
 * @Date 2020/5/7 10:38
 * @Title 621. 任务调度器
 * @Description //TODO
 **/

public class LeastInterval {

    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'B', 'C', 'C', 'C', 'D', 'D', 'D'};
        LeastInterval leastInterval = new LeastInterval();
        leastInterval.leastInterval(tasks, 2);
    }

    //贪心 待理解    执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
    public int leastIntervalII(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    //优先队列：执行用时 :36 ms, 在所有 Java 提交中击败了18.28%的用户
    public int leastIntervalI(char[] tasks, int n) {
        int[] taskSet = new int[26];
        for (char c : tasks) {
            taskSet[c - 'A']++;
        }
        int time = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int task : taskSet) {
            if (task > 0) queue.add(task);
        }
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> list = new LinkedList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    int task = queue.poll();
                    if (task > 1) list.add(task - 1);
                }
                time++;
                i++;
                if (queue.isEmpty() && list.size() == 0) break;
            }
            queue.addAll(list);
        }
        return time;
    }

    //排序：执行用时 :7 ms, 在所有 Java 提交中击败了53.03%的用户
    public int leastInterval(char[] tasks, int n) {
        int[] taskSet = new int[26];
        for (char c : tasks) {
            taskSet[c - 'A']++;
        }
        Arrays.sort(taskSet);
        int time = 0;
        while (taskSet[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (taskSet[25] == 0) break;
                if (i < 26 && taskSet[25 - i] > 0) {
                    taskSet[25 - i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(taskSet);
        }
        return time;
    }

}

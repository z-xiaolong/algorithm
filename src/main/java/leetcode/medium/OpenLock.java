package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2021/9/22 21:23
 * @Title
 * @Description //TODO
 **/

public class OpenLock {

    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        String[] deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        openLock.openLock(deadends, "8888");
    }

    public int openLock(String[] deadends, String target) {
        boolean[] visited = new boolean[10000];
        for (String deadend : deadends) {
            int num = Integer.parseInt(deadend);
            visited[num] = true;
        }
        int t = Integer.parseInt(target);
        if (t == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        if (visited[0]) return -1;
        visited[0] = true;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                int operate = 1;
                for (int j = 0; j < 4; j++) {
                    int add;
                    int sub;
                    if ((num / operate) % 10 < 9) {
                        add = num + operate;
                    } else {
                        add = num - 9 * operate;
                    }
                    if ((num / operate) % 10 > 0) {
                        sub = num - operate;
                    } else {
                        sub = num + 9 * operate;
                    }
                    if (!visited[add]) {
                        if (add == t) return step;
                        visited[add] = true;
                        queue.add(add);
                    }
                    if (!visited[sub]) {
                        if (sub == t) return step;
                        visited[sub] = true;
                        queue.add(sub);
                    }
                    operate *= 10;
                }
            }
            step++;
        }
        return -1;
    }
}

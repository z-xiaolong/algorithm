package leetcode.hard;

import java.util.*;

/**
 * @Author long
 * @Date 2020/5/17 15:08
 * @Title 630. 课程表 III
 * @Description //TODO
 **/

public class ScheduleCourse {

    public static void main(String[] args) {
        ScheduleCourse course = new ScheduleCourse();
        int[][] c = new int[][]{{5, 5}, {4, 6}, {2, 6}};
        course.scheduleCourse(c);
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int startTime = 0;
        for (int[] course : courses) {
            if (startTime + course[0] <= course[1]) {
                queue.offer(course[0]);
                startTime += course[0];
            } else if (!queue.isEmpty() && queue.peek() > course[0]) {
                startTime += course[0] - queue.poll();
                queue.offer(course[0]);
            }
        }
        return queue.size();
    }
}

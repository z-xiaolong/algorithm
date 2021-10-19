package leetcode.medium;

import java.util.TreeMap;

/**
 * @Author long
 * @Date 2021/9/29 15:46
 * @Title
 * @Description //TODO
 **/

public class MyCalendarThree {
    private TreeMap<Integer, Integer> calendar;

    public MyCalendarThree() {
        calendar = new TreeMap<>();
    }

    public int book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        int count = 0;
        int res = 0;
        for (int v : calendar.values()) {
            count += v;
            res = Math.max(res, count);
        }
        return res;
    }
}

package leetcode.medium;

import java.util.TreeMap;

/**
 * @Author long
 * @Date 2021/9/29 15:38
 * @Title
 * @Description //TODO
 **/

public class MyCalendarTwo {

    TreeMap<Integer, Integer> calendar;

    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        int cnt = 0;
        for (Integer v : calendar.values()) {
            cnt += v;
            if (cnt >= 3) {
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}

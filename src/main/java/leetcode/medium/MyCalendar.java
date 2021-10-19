package leetcode.medium;

import java.util.TreeMap;

/**
 * @Author long
 * @Date 2021/9/29 13:40
 * @Title
 * @Description //TODO
 **/

public class MyCalendar {

    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);  //res <= start
        Integer next = calendar.ceilingKey(start); // res >= start
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

package javaCore;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: long
 * @Date: 2020/9/2 17:25
 * @Title
 * @Description:
 */
public class MyCalendar {


    public static void main(String[] args) {
        MyCalendar cal = new MyCalendar();
        System.out.println(cal.book(10, 20));
        System.out.println(cal.book(50, 60));
        System.out.println(cal.book(10, 40));
        System.out.println(cal.book(5, 15));
        System.out.println(cal.book(5, 10));
        System.out.println(cal.book(25, 55));
        /*cal.book(50, 60); // returns 1
        cal.book(10, 40); // returns 2
        cal.book(5, 15); // returns 3
        cal.book(5, 10); // returns 3
        cal.book(25, 55); // returns 3*/
    }


    private final TreeMap<Integer, Integer> calendar = new TreeMap<>();

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

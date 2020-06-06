package leetcode.swordOffer.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2020/4/1 11:21
 * @Title
 * @Description //TODO
 **/

public class MedianFinder {

    PriorityQueue<Integer> maximum;
    PriorityQueue<Integer> minimum;
    private int size;

    //执行用时 :60 ms, 在所有 Java 提交中击败了97.34%的用户
    public MedianFinder() {
        maximum = new PriorityQueue<>((o1, o2) -> {
            if (o1 > o2) {
                return -1;
            } else if (o1 < o2) {
                return 1;
            }
            return 0;
        });
        minimum = new PriorityQueue<>();
        maximum.add(Integer.MIN_VALUE);
        minimum.add(Integer.MAX_VALUE);
        size = 0;
    }

    public void addNum(int num) {
        int max = maximum.peek();
        int min = minimum.peek();
        if (size % 2 == 0) {
            if (num > min) {
                maximum.add(minimum.poll());
                minimum.add(num);
            } else {
                maximum.add(num);
            }
        } else {
            if (num >= max) {
                minimum.add(num);
            } else {
                minimum.add(maximum.poll());
                maximum.add(num);
            }
        }
        size++;
    }

    public double findMedian() {
        if (size % 2 == 0) {
            int max = maximum.peek();
            int min = minimum.peek();
            return ((double) max + (double) min) / 2;
        } else {
            return (double) maximum.peek();
        }
    }
}

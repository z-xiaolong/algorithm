package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/3/7 9:53
 * @Title 面试题59 - II. 队列的最大值
 * @Description 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的**均摊**时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 **/

public class MaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> maxValue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxValue = new LinkedList<>();
    }

    public int max_value() {
        if (maxValue.isEmpty()) {
            return -1;
        }
        return maxValue.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!maxValue.isEmpty() && maxValue.peekLast() < value) {
            maxValue.pollLast();
        }
        maxValue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int num = queue.poll();
        if (!maxValue.isEmpty() && num == maxValue.peekFirst()) {
            maxValue.pollFirst();
        }
        return num;
    }
}

package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author long
 * @Date 2020/5/26 10:23
 * @Title 933. 最近的请求次数
 * @Description //TODO
 **/

public class RecentCounter {

    private Deque<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.addFirst(t);
        while (deque.peekLast() < t - 3000) {
            deque.pollLast();
        }
        return deque.size();
    }
}

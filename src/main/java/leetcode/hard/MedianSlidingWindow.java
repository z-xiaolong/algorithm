package leetcode.hard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2021/2/3 11:52
 * @Title
 * @Description //TODO
 **/

public class MedianSlidingWindow {

    class DualHeap {
        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;
        private Map<Integer, Integer> map;

        private int k;
        private int smallSize;
        private int largeSize;

        public DualHeap(int k) {
            this.small = new PriorityQueue<>(Comparator.comparingInt(o -> o));
            this.large = new PriorityQueue<>((o1, o2) -> o2 - o1);
            this.map = new HashMap<>();
            this.k = k;
        }

        public double getMedian() {
            return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
        }

        public void insert(int num) {
            
        }
    }
}

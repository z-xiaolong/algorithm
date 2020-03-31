package exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/3/29 20:01
 * @Title
 * @Description //TODO
 **/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> minQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long num = in.nextLong();
            queue.add(num);
            minQueue.add(num);
        }
        long count = 0;
        while (queue.peek() + count >= n) {
            long num = queue.poll();
            queue.add(num - n - 1);
            count++;
        }
        System.out.println(count);
    }
}

package test.structure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2020/3/15 14:46
 * @Title
 * @Description //TODO
 **/

public class priority {
    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1, 9}, {2, 3}, {7, 5, 8}, {3, 4}, {7, 0}};
        Arrays.sort(arrays, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i][0] + " " + arrays[i][1]);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.add(1);
        queue.add(4);
        queue.add(2);
        queue.add(3);
        queue.add(6);
        queue.add(0);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}

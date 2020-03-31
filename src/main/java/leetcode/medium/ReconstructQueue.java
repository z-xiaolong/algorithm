package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/26 18:01
 * @Title 406. 根据身高重建队列
 * @Description //TODO
 **/

public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        ReconstructQueue queue = new ReconstructQueue();
        queue.reconstructQueue(people);
    }

    //官方最佳解: 执行用时 :10 ms, 在所有 Java 提交中击败了61.23%的用户
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(people);
    }

    //执行用时 :15 ms, 在所有 Java 提交中击败了23.72%的用户
    public int[][] reconstructQueueI(int[][] people) {
        if (people.length <= 1) {
            return people;
        }
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int[][] output = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            insert(output, people[i]);
        }
        return output;
    }

    public void insert(int[][] output, int[] one) {
        int index = one[1];
        while (index < output.length && output[index] != null) {
            int[] temp = output[index];
            output[index] = one;
            one = temp;
            index++;
        }
        if (output[index] == null) {
            output[index] = one;
        }
    }

    public void swap(int[][] people, int i, int j) {
        if (i == j) {
            return;
        }
        int[] temp = people[j];
        for (int k = j; k > i; k--) {
            people[k] = people[k - 1];
        }
        people[i] = temp;
    }
}

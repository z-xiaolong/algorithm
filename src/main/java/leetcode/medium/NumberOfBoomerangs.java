package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2021/9/13 10:17
 * @Title
 * @Description //TODO
 **/

public class NumberOfBoomerangs {

    public static void main(String[] args) {
        NumberOfBoomerangs test = new NumberOfBoomerangs();
        int[][] points = new int[][]{{1, 0}, {0, 0}, {2, 0}};
        test.numberOfBoomerangs(points);
    }

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] point : points) {
            Map<Long, Integer> map = new HashMap<>();
            for (int[] p : points) {
                long distance = distance(point, p);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                long k = entry.getKey();
                int v = entry.getValue();
                if (v > 1) {
                    ans += v * (v - 1) / 2;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        return ans * 2;
    }

    public long distance(int[] point1, int[] point2) {
        long x1 = (long) point1[0];
        long y1 = (long) point1[1];
        long x2 = (long) point2[0];
        long y2 = (long) point2[1];
        return Math.abs(x1 - x2) * Math.abs(x1 - x2) + Math.abs(y1 - y2) * Math.abs(y1 - y2);
    }
}

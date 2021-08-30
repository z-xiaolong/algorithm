package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2021/1/31 10:27
 * @Title
 * @Description //TODO
 **/

public class Contest226 {

    public static void main(String[] args) {

    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        int m = queries.length;
        boolean[] res = new boolean[m];
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            long max = (long) (query[2]) * (long) (query[1] + 1);
            if (query[0] == 0) {
                res[i] = sum[query[0]] >= query[1] + 1;
                continue;
            }
            if (sum[query[0]] > query[1] && sum[query[0] - 1] < max) {
                res[i] = true;
            }
        }
        return res;
    }


    public int[] restoreArray(int[][] adjacentPairs) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map= new HashMap<>();
        int n = adjacentPairs.length + 1;
        for (int[] adjacent : adjacentPairs) {
            if (set.contains(adjacent[0])) {
                set.remove(adjacent[0]);
            } else {
                set.add(adjacent[0]);
            }
            if (set.contains(adjacent[1])) {
                set.remove(adjacent[1]);
            } else {
                set.add(adjacent[1]);
            }
        }
        
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

        }

        return res;
    }


    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int most = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int index = getIndex(i);
            if (!map.containsKey(index)) {
                map.put(index, 0);
            }
            int count = map.get(index) + 1;
            map.put(index, count);
            most = Math.max(most, count);
        }
        return most;
    }

    public int getIndex(int number) {
        int res = 0;
        while (number > 0) {
            res += number % 10;
            number /= 10;
        }
        return res;
    }
}

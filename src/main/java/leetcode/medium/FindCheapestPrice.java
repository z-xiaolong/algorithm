package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2021/8/24 9:40
 * @Title
 * @Description //TODO
 **/

public class FindCheapestPrice {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[n][k + 2];
        final int MAX = 1000000;
        for (int[] d : dp) {
            Arrays.fill(d, MAX);
        }
        dp[src][0] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                dp[flight[1]][i] = Math.min(dp[flight[0]][i - 1] + flight[2], dp[flight[1]][i]);
            }
        }
        int min = MAX;
        for (int i = 0; i <= k + 1; i++) {
            min = Math.min(min, dp[dst][i]);
        }
        return min == MAX ? -1 : min;
    }


    private int min = Integer.MAX_VALUE;

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>(n);
        for (int[] flight : flights) {
            if (!map.containsKey(flight[0])) {
                map.put(flight[0], new ArrayList<>());
            }
            map.get(flight[0]).add(flight);
        }
        int[][] dp = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dfs(map, dp, src, dst, k + 1, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void dfs(Map<Integer, List<int[]>> map, int[][] dp, int index, int dst, int k, int price) {
        if (k < 0 || price >= min || price > dp[index][k]) {
            return;
        }
        dp[index][k] = Math.min(dp[index][k], price);
        if (index == dst) {
            min = price;
            return;
        }
        List<int[]> list = map.get(index);
        if (list == null) return;
        for (int[] flight : list) {
            dfs(map, dp, flight[1], dst, k - 1, price + flight[2]);
        }
    }
}

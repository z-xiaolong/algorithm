package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author long
 * @Date 2021/10/7 10:44
 * @Title
 * @Description //TODO
 **/

public class MinCost {


    /*   public static void main(String[] args) {
           int[] houses = new int[]{0, 0, 0, 0, 0};
           int[][] cost = new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
           MinCost minCost = new MinCost();
           minCost.minCost(houses, cost, 5, 2, 3);
       }
   */
    //粉刷房子III
    //dp[i][j][k] = dp[i-1][j0~jn][k-1/k]
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int INF = Integer.MAX_VALUE / 2;
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                Arrays.fill(dp[i][j], INF);
                if (houses[i - 1] != 0 && houses[i - 1] != j) {
                    continue; //当前房屋已粉刷且颜色不为j，不可能粉刷其他颜色，因此不做处理
                }
                for (int k = 1; k <= i && k <= target; k++) {
                    for (int l = 1; l <= n; l++) {
                        if (j == l) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k]);
                        } else {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k - 1]);
                        }
                    }
                    if (houses[i - 1] != j) {
                        dp[i][j][k] += cost[i - 1][j - 1];
                    }
                }
            }
        }
        int min = INF;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, dp[m][i][target]);
        }
        return min == INF ? -1 : min;
    }

    //粉刷房子
    public int minCost(int[][] costs) {
        int[] dp = new int[3];
        for (int[] cost : costs) {
            int zero = dp[0];
            int one = dp[1];
            int two = dp[2];
            dp[0] = Math.min(one + cost[1], two + cost[2]);
            dp[1] = Math.min(zero + cost[0], two + cost[2]);
            dp[2] = Math.min(one + cost[1], zero + cost[0]);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        pathWithObstacles(obstacleGrid);
    }

    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] != 0) return new ArrayList<>();
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        List<int[]>[] dp = new List[m + 1];
        dp[1] = new ArrayList<>();
        dp[1].add(new int[]{0, 0});
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (obstacleGrid[i][j - 1] == 0) {
                    if (dp[j] != null) {
                        dp[j].add(new int[]{i, j - 1});
                    } else if (dp[j - 1] != null) {
                        dp[j] = new ArrayList<>(dp[j - 1]);
                        dp[j].add(new int[]{i, j - 1});
                    }
                } else {
                    dp[j] = null;
                }
            }
        }
        if (dp[m] == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < dp[m].size(); i++) {
            int[] e = dp[m].get(i);
            List<Integer> list = new ArrayList<>();
            list.add(e[0]);
            list.add(e[1]);
            ans.add(list);
        }
        return ans;
    }

    public boolean dfs(List<List<Integer>> ans, int[][] obstacleGrid, int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        ans.add(list);
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (i == n - 1 && j == m - 1) {
            return true;
        }
        boolean flag = false;
        obstacleGrid[i][j] = 1;
        if (i + 1 < n && obstacleGrid[i + 1][j] == 0) {
            flag = dfs(ans, obstacleGrid, i + 1, j);
        }
        if (!flag && j + 1 < m && obstacleGrid[i][j + 1] == 0) {
            flag = dfs(ans, obstacleGrid, i, j + 1);
        }
        if (!flag) ans.remove(ans.size() - 1);
        return flag;
    }
}

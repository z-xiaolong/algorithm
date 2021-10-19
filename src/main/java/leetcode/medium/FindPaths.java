package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author long
 * @Date 2021/10/15 16:36
 * @Title
 * @Description //TODO
 **/

public class FindPaths {

    public static void main(String[] args) {
        FindPaths findPaths = new FindPaths();
        findPaths.findPaths(1, 3, 3, 0, 1);
        Set<int[]> set = new HashSet<>();
        set.add(new int[]{1, 2});
        set.add(new int[]{1, 2, 3});
        set.add(new int[]{1, 2});
        for (int[] e : set) {
            System.out.println(e);
        }
    }

    private int mod = (int) 1e9 + 7;
    private int[] X = new int[]{0, 0, 1, -1};
    private int[] Y = new int[]{1, -1, 0, 0};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][] dp = new long[m][n];
        dp[startRow][startColumn] = 1;
        long ans = 0;
        for (int i = 0; i < maxMove; i++) {
            long[][] newDp = new long[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (dp[j][k] > 0) {
                        for (int l = 0; l < 4; l++) {
                            int x = X[l] + j;
                            int y = Y[l] + k;
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                newDp[x][y] = (newDp[x][y] + dp[j][k]) % mod;
                            } else {
                                ans = (ans + dp[j][k]) % mod;
                            }
                        }
                    }
                }
            }
            dp = newDp;
        }
        return (int) (ans % mod);
    }

}

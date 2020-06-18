package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/6/14 14:05
 * @Title 5188. 树节点的第 K 个祖先
 * @Description //TODO
 **/

public class TreeAncestor {

    private final int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        dp = new int[n + 1][16];
        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }
        for (int i = 1; i < 16; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[j][i - 1] == -1) {
                    dp[j][i] = -1;
                } else {
                    dp[j][i] = dp[dp[j][i - 1]][i - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 15; i >= 0; i--) {
            if (node != -1 && k >= (1 << i)) {
                node = dp[node][i];
                k -= (1 << i);
            }
        }
        return node;
    }
}

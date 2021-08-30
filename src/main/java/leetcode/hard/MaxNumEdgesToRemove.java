package leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author long
 * @Date 2021/1/27 14:52
 * @Title
 * @Description //1579. 保证图可完全遍历
 **/

public class MaxNumEdgesToRemove {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parent = new int[n + 1];
        int len = edges.length;
        int res = len;
        int size = n;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                int x = find(parent, edge[1]);
                int y = find(parent, edge[2]);
                if (x == y) {
                    res--;
                } else {
                    parent[x] = y;
                    size--;
                }
            }
        }
        int[] A = new int[n + 1];
        int[] B = parent;
        int a = size;
        int b = size;
        if (A.length >= 0) {
            System.arraycopy(parent, 0, A, 0, A.length);
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                int x = find(A, edge[1]);
                int y = find(A, edge[2]);
                if (x == y) {
                    res--;
                } else {
                    A[x] = y;
                    a--;
                }
            } else if (edge[0] == 2) {
                int x = find(B, edge[1]);
                int y = find(B, edge[2]);
                if (x == y) {
                    res--;
                } else {
                    B[x] = y;
                    b--;
                }
            }
        }
        if (a != 1 || b != 1) {
            return -1;
        }
        return len - res;
    }

    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

}

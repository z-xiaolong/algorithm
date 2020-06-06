package leetcode.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/4/12 10:28
 * @Title
 * @Description //TODO
 **/

public class Contest184 {

    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    set.add(words[i]);
                }
                if (words[i].contains(words[j])) {
                    set.add(words[j]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        int[] p = new int[m];
        for (int i = 0; i < p.length; i++) {
            p[i] = i + 1;
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = getIndex(p, queries[i]);
            move(p, res[i]);
        }
        return res;
    }

    public void move(int[] p, int num) {
        for (int i = num; i > 0; i--) {
            int temp = p[i];
            p[i] = p[i - 1];
            p[i - 1] = temp;
        }
    }

    public int getIndex(int[] p, int num) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == num) {
                return i;
            }
        }
        return -1;
    }


    //5382. HTML 实体解析器
    public String entityParser(String text) {
        return text.replace("&quot;", "\"")
                .replace("&apos;", "'")
                .replace("&amp;", "&")
                .replace("&gt;", ">")
                .replace("&lt;", "<")
                .replace("&frasl;", "/");
    }

    //5383. 给 N x 3 网格图涂色的方案数
    long count = 0;

    public int numOfWays(int n) {
        if (n == 1) return 12;
        long[] dp = new long[n + 1];
        dp[1] = 12;
        int[] flag = new int[2];
        flag[0] = 6;
        flag[1] = 6;
        int index = 1;
        long count = 0;
        while (index < n) {

        }
        return (int) (count % 1000000007);
    }

    public void backtrack(int[][] grid, int i, int j) {
        if (i >= grid.length) {
            count++;
            return;
        }
        if (j >= grid[0].length) {
            backtrack(grid, i + 1, 0);
            return;
        }
        if (j - 1 >= 0 && i - 1 >= 0) {
            for (int k = 1; k <= 3; k++) {
                if (k != grid[i][j - 1] && k != grid[i - 1][j]) {
                    grid[i][j] = k;
                    backtrack(grid, i, j + 1);
                }
            }
        } else if (i == 0 && j - 1 >= 0) {
            for (int k = 1; k <= 3; k++) {
                if (k != grid[i][j - 1]) {
                    grid[i][j] = k;
                    backtrack(grid, i, j + 1);
                }
            }
        } else if (j == 0 && i - 1 >= 0) {
            for (int k = 1; k <= 3; k++) {
                if (k != grid[i - 1][j]) {
                    grid[i][j] = k;
                    backtrack(grid, i, j + 1);
                }
            }
        } else if (j == 0 && i == 0) {
            for (int k = 1; k <= 3; k++) {
                grid[i][j] = k;
                backtrack(grid, i, j + 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}

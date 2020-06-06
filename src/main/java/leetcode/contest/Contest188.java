package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2020/5/10 10:28
 * @Title
 * @Description //TODO
 **/

public class Contest188 {


    //5404. 用栈操作构建数组
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new LinkedList<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            if (target[j] != i) {
                res.add("Push");
                res.add("Pop");
            } else {
                res.add("Push");
                j++;
            }
        }
        return res;
    }

    //5405. 形成两个异或相等数组的三元组数目
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (i == 0) dp[j][j + i] = arr[j];
                else dp[j][j + i] = dp[j + 1][j + i] ^ arr[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if (dp[i][j - 1] == dp[j][k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    //5406. 收集树上所有苹果的最少时间
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int[] edge : edges) {
            hashMap.put(edge[1], edge[0]);
        }
        for (int i = 0; i < hasApple.size(); i++) {
            if (hasApple.get(i)) {
                int node = i;
                while (!set.contains(node)) {
                    set.add(node);
                    node = hashMap.get(node);
                }
            }
        }
        return (set.size() - 1) * 2;
    }

    //5407. 切披萨的方案数
    public int ways(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();
        boolean[][] flag = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            String s = pizza[i];
            for (int j = 0; j < cols; j++) {
                if (s.charAt(j) == 'A') flag[i][j] = true;
            }
        }
        long count = 0;
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {

            }
        }
        return (int) count;
    }

    public String removeOuterParentheses(String S) {
        StringBuilder builder = new StringBuilder();
        int start = 0;
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (count == 0) start = i;
                count++;
            } else if (S.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                builder.append(S.substring(start, i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] d = new long[n + 1];
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = in.nextLong();
        }
        for (int i = 1; i <= n; i++) {
            p[i] = in.nextInt();
        }
        long[][] dp = new long[n + 1][n * 2 + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        //dp[i][j] 表示通过前i只怪兽花费j个金币获得的最大武力值
        //dp[i][j] = Max(dp[i-1][j-p[i]]+d[i],dp[i-1][j]) 贿赂/不贿赂
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * n; j++) {
                if (j >= p[i] && dp[i - 1][j - p[i]] != -1) {
                    dp[i][j] = dp[i - 1][j - p[i]] + d[i];
                }
                if (dp[i - 1][j] != -1 && dp[i - 1][j] >= d[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= 2 * n; i++) {
            if (dp[n][i] != -1) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}

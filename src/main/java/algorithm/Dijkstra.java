package algorithm;

import java.util.*;

/**
 * @Author long
 * @Date 2021/3/6 17:33
 * @Title
 * @Description //TODO
 **/

public class Dijkstra {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        int start = Integer.parseInt(s.split(" ")[0]);
        int end = Integer.parseInt(s.split(" ")[1]);
        List<List<int[]>> matrix = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
        }
        while (!"0 0 0".equals(s = in.nextLine())) {
            String[] lines = s.split(" ");
            int v1 = Integer.parseInt(lines[0]);
            int v2 = Integer.parseInt(lines[1]);
            int e = Integer.parseInt(lines[2]);
            if (matrix.get(v1) == null) {
                matrix.set(v1, new ArrayList<>());
            }
            if (matrix.get(v2) == null) {
                matrix.set(v2, new ArrayList<>());
            }
            matrix.get(v1).add(new int[]{v2, e});
            matrix.get(v2).add(new int[]{v1, e});
        }
        System.out.println(dijkstra(matrix, start, end, n));
        System.out.println(dijkstraP(matrix, start, end, n));
    }
    /*
1 2 1
0 1 2
3 1 3
3 2 1
4 3 1
5 4 2
0 0 0
     */


    public static int dijkstra(List<List<int[]>> matrix, int start, int end, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            List<int[]> list = matrix.get(index);
            for (int[] v : list) {
                if (dp[v[0]] > dp[index] + v[1]) {
                    dp[v[0]] = dp[index] + v[1];
                    queue.add(v[0]);
                }
            }
        }
        return dp[end];
    }


    public static int dijkstraP(List<List<int[]>> matrix, int start, int end, int n) {
        int[] dp = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> dp[a]));
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            List<int[]> list = matrix.get(index);
            for (int[] v : list) {
                if (dp[v[0]] > dp[index] + v[1]) {
                    dp[v[0]] = dp[index] + v[1];
                    if (!visited[v[0]]) {
                        queue.add(v[0]);
                        visited[v[0]] = true;
                    }
                }
            }
        }
        return dp[end];
    }
}

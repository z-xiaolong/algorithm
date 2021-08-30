package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2021/3/14 10:37
 * @Title
 * @Description //TODO
 **/

public class Contest232 {

    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
    }


    public static List<Integer> partitionLabels(String S) {
        int[][] map = new int[26][2];
        for (int[] m : map) {
            Arrays.fill(m, -1);
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map[c - 'a'][0] == -1) {
                map[c - 'a'][0] = i;
            }
            map[c - 'a'][1] = i;
        }
        Arrays.sort(map, Comparator.comparingInt(a -> a[0]));
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (map[i][1] == -1) {
            i++;
        }
        int left = map[i][0];
        int right = map[i][1];
        for (i++; i < map.length; i++) {
            if (right > map[i][0]) {
                right = Math.max(right, map[i][1]);
            } else {
                res.add(right - left + 1);
                left = map[i][0];
                right = map[i][1];
            }
        }
        res.add(right - left + 1);
        return res;
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            double x = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
            double y = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
            return Double.compare(y, x);
        });
        for (int[] c : classes) {
            priorityQueue.offer(new double[]{c[0], c[1]});
        }
        while (extraStudents > 0) {
            double[] c = priorityQueue.poll();
            c[0] += 1.0d;
            c[1] += 1.0d;
            priorityQueue.offer(c);
            extraStudents--;
        }
        double res = 0;
        while (!priorityQueue.isEmpty()) {
            double[] c = priorityQueue.poll();
            res += c[0] / c[1];
        }
        return res / classes.length;
    }


    public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int[] edge : edges) {
            if (set.contains(edge[0])) {
                return edge[0];
            } else if (set.contains(edge[1])) {
                return edge[1];
            }
            set.add(edge[0]);
            set.add(edge[1]);
        }
        return 0;
    }


    public boolean areAlmostEqual(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }
        int first = -1;
        int second = -1;
        for (int i = 0; i < m; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        if (first == second) {
            return true;
        }
        if (second == -1) {
            return false;
        }
        return s1.charAt(first) == s2.charAt(second)
                && s1.charAt(second) == s2.charAt(first);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        for (int i = 0; i < m / 2 && i < n / 2; i++) {
            circle(matrix, res, i);
        }
        return res;
    }

    public void circle(int[][] matrix, List<Integer> list, int i) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int j = i; j <= n - i - 1; j++) {
            list.add(matrix[i][j]);
        }
        for (int j = i + 1; j <= m - i - 1; j++) {
            list.add(matrix[j][n - i - 1]);
        }
        for (int j = n - i - 2; j >= i && m - i - 1 > i; j--) {
            list.add(matrix[m - i - 1][j]);
        }
        for (int j = m - i - 2; j > i && n - i - 1 > i; j--) {
            list.add(matrix[j][i]);
        }
    }

}

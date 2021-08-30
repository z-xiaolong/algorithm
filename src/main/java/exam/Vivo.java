package exam;

import org.springframework.data.querydsl.QuerydslUtils;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/9/12 20:10
 * @Title
 * @Description:
 */
public class Vivo {


    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = Integer.parseInt(in.nextLine());
        String[] sets = in.nextLine().split(" ");
        int[] start = new int[]{Integer.parseInt(sets[0]), Integer.parseInt(sets[1])};
        int[] end = new int[]{Integer.parseInt(sets[2]), Integer.parseInt(sets[3])};
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = in.nextLine().toCharArray();
        }
        System.out.println(getMin(matrix, start, end));
    }

    public static boolean isInMaze(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static int getMin(char[][] matrix, int[] start, int[] end) {
        int n = matrix.length;
        PriorityQueue<Node> midHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        midHeap.offer(new Node(start[0], start[1], 0));

        int[][] visited = new int[n][n];

        for (int[] arr : visited) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        while (!midHeap.isEmpty()) {

            Node cur = midHeap.poll();
            if (cur.x == end[0] && cur.y == end[1]) return cur.distance;
            for (int[] dir : dirs) {
                int nx = cur.x;
                int ny = cur.y;
                while (isInMaze(nx + dir[0], ny + dir[1])
                        && matrix[nx + dir[0]][ny + dir[1]] != '#'
                        && matrix[nx + dir[0]][ny + dir[1]] != '@') {
                    nx += dir[0];
                    ny += dir[1];
                }
                int distance = cur.distance + Math.abs(nx - cur.x) + Math.abs(ny - cur.y);
                if (visited[nx][ny] > distance) {
                    midHeap.offer(new Node(nx, ny, distance));
                    visited[nx][ny] = distance;
                }
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Integer left = 0;
        Integer right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }
        String res = str.substring(0, left) + str.substring(left + 1);
        if (left + 1 == right) {
            System.out.println(res);
            return;
        }
        if (valid(str, left + 1, right)) {
            System.out.println(res);
        } else if (valid(str, left, right - 1)) {
            res = str.substring(0, right) + str.substring(right + 1);
            System.out.println(res);
        } else {
            System.out.println("false");
        }

    }

    public static boolean valid(String s, Integer left, Integer right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }


    public String compileSeq(String input) {
        String[] files = input.split(",");
        int n = files.length;
        int[] degrees = new int[n];
        List<List<Integer>> adj = new ArrayList<>(n);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int file = Integer.parseInt(files[i]);
            if (file != -1) {
                degrees[i]++;
                adj.get(file).add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0) queue.add(i);
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            int index = queue.poll();
            Collections.sort(adj.get(index));
            for (int j : adj.get(index)) {
                degrees[j]--;
                if (degrees[j] == 0) queue.add(j);
            }
            builder.append(index).append(",");
        }
        if (builder.length() <= 1) return "";
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

}

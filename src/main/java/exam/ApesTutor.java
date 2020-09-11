package exam;

import org.junit.Test;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/1 19:29
 * @Title 猿辅导
 * @Description:
 */
public class ApesTutor {

    public static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeNode[] nodes = new TreeNode[n];
        int root = 0;
        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            int index = in.nextInt();
            if (nodes[i] == null) {
                nodes[i] = new TreeNode();
            }
            nodes[i].value = value;
            if (index == 0) {
                root = i;
            } else if (nodes[index - 2] == null) {
                nodes[index - 2] = new TreeNode();
                nodes[index - 2].next.add(i);
            }

        }
        dfs(nodes, root);
        System.out.println(MAX);
    }

    public static int dfs(TreeNode[] node, int index) {
        int max = 0;
        if (node[index].next.size() == 0) {
            return Math.max(node[index].value, 0);
        }
        for (int i : node[index].next) {
            max = Math.max(max, dfs(node, i));
        }
        max += node[index].value;
        MAX = Math.max(MAX, max);
        return Math.max(max, 0);
    }

    static class TreeNode {
        int value;
        List<Integer> next;

        public TreeNode() {
            this.next = new ArrayList<>();
        }
    }


    public static int solution(int[][] courses) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int ans = 0, cnt = 0;
        for (int[] i : courses) {
            int start = i[0], end = i[1];
            tmap.put(start, tmap.getOrDefault(start, 0) + 1);
            tmap.put(end, tmap.getOrDefault(end, 0) - 1);
        }
        for (int k : tmap.keySet()) {
            cnt += tmap.get(k);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    @Test
    public void test() {
        circumference(3);
    }

    public double circumference(int k) {
        double res = 0.0;
        double[] mod = new double[7];
        mod[1] = Math.PI / 3.0;
        mod[2] = Math.PI * Math.sqrt(3) / 3.0;
        mod[3] = Math.PI * 2.0 / 3.0;
        mod[4] = Math.PI * Math.sqrt(3) / 3.0;
        mod[5] = Math.PI / 3.0;
        mod[6] = 0.0;
        for (int i = 0; i <= k; i++) {
            res += mod[i % 7];
        }
        return res;
    }

    public int solve(int n, int x, int[] a) {
        Arrays.sort(a);
        int mid = binarySearch(a, x);
        if (a[mid] < x) return 0;
        long sum = 0;
        for (int i = mid; i < a.length; i++) {
            sum += a[i];
        }
        int count = a.length - mid;
        while (mid > 0) {
            mid--;
            sum += a[mid];
            if (sum / (count + 1) >= x) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public int binarySearch(int[] a, int x) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < x) {
                left = mid + 1;
            } else if (a[mid] >= x) {
                right = mid;
            }
        }
        return left;
    }


    public int solve(int n, int[] b) {
        Arrays.sort(b);
        int[] sub = new int[n];
        for (int i = 1; i < n; i++) {
            sub[i] = b[i] - b[i - 1];
        }
        int count = 0;
        for (int i = 1; i < n; i++) {

        }


        return count;
    }



}

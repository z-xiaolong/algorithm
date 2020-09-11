package exam;


import java.util.*;

/**
 * @Author long
 * @Date 2020/4/26 20:01
 * @Title
 * @Description //TODO
 **/

public class Tencent {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int k = Integer.parseInt(in.nextLine());

        System.out.println(min(s, k));*/
        solution1();

        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(dfs(a, 1, n, 0));*/
    }


    public static String min(String s, int k) {
        int[] hash = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            hash[s.charAt(i) - 'a']++;
        }
        int i = 0;
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Set<String> set = new HashSet<>();
        for (; i < hash.length; i++) {
            if (hash[i] > 0) break;
        }
        int j = 0;
        while (j < n) {
            char c = s.charAt(j);
            if (c - 'a' == i || queue.size() < k) {
                StringBuilder builder = new StringBuilder();
                int m = j;
                while (m < 6 && m < n) {
                    builder.append(s.charAt(m));
                    m++;
                    String sub = builder.toString();
                    if (!set.contains(sub)) {
                        queue.add(builder.toString());
                        set.add(sub);
                    }
                    if (queue.size() > k) {
                        String str = queue.poll();
                        set.remove(str);
                    }
                }
            }
            j++;
        }
        return queue.peek();
    }


    public static void solution1() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            long temp = n;
            long mul = 1;
            while (temp > 0) {
                temp /= 10;
                mul *= 10;
            }
            mul /= 10;
            long maxi = n / mul * mul - 1;
            long maxj = n - maxi;
            System.out.println(solution(maxi) + solution(maxj));
        }
    }


    public static int solution(long x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static int solution1(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            if (bit == 9) sum += 9;
            else {

            }
            n = n / 10;
        }
        return sum;
    }


    public static int dfs(int[] a, int left, int right, int h) {
        if (left > right) return 0;
        int min = left;
        for (int i = left; i <= right; i++) {
            if (a[i] < a[min]) min = i;
        }
        int t1 = dfs(a, left, min - 1, a[min]);
        int t2 = dfs(a, min + 1, right, a[min]);
        return Math.min(t1 + t2 + a[min] - h, right - left + 1);
    }


    public static void solution4() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(subSolution(a, 0, a.length - 1));
    }

    public static int subSolution(int[] a, int left, int right) {
        if (left > right) return 0;
        if (left == right) return a[left];
        int min = left;
        int max = right;
        for (int i = left; i <= right; i++) {
            if (a[i] < a[min]) min = i;
            if (a[i] > a[max]) max = i;
        }
        int count = min;
        int i = 0;
        int j = 0;
        for (int k = left; k <= right; k++) {
            if ((a[k] -= min) > 0) j++;
            else {
                count += subSolution(a, i, j - 1);
                j++;
                i = j;
            }
        }
        return count;
    }


    public static void solution3() {

    }


    public static double minDistance(int[][] A, int[][] B) {
        double distance = Double.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                double d = getDistance(A[i][0], A[i][1], B[j][0], B[j][1]);
                distance = Math.min(d, distance);
                if (distance == 0) return distance;
            }
        }
        return distance;
    }

    public static double getDistance(int x, int y, int a, int b) {
        int res = (x - a) * (x - a) + (y - b) * (y - b);
        return Math.sqrt(res);
    }


}


//面试

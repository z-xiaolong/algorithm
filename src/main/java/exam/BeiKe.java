package exam;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/11 18:33
 * @Title
 * @Description:
 */
public class BeiKe {



    public static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        set.add("SJ");
        set.add("JB");
        set.add("BS");
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            int res = result(s.split(" "));
            if(res == 0) System.out.println("same");
            else if(res > 0) System.out.println("left");
            else System.out.println("right");
        }

    }
    public static int result(String[] str) {
        String left = str[0];
        String right = str[1];
        int l = 0;
        int r = 0;
        if (set.contains(left + str[2])) l++;
        if (set.contains(left + str[3])) l++;
        if (set.contains(right + str[2])) r++;
        if (set.contains(right + str[3])) r++;
        return l - r;
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        int left = 1, right = n / 2;
        int L;
        while (left < right) {
            L = left + (right - left) / 2;
            if (search(L, str)) left = L + 1;
            else right = L;
        }
        if (!search(left, str)) left--;
        if (left == 0) left++;
        System.out.println(n - left + 1);
    }

    public static boolean search(int len, String str) {
        if (len == 0) return true;
        int n = str.length();
        for (int i = 0; i < n - len; i++) {
            String sub = str.substring(i, i + len);
            String right = str.substring(i + len);
            String left = str.substring(0, i);
            if (right.contains(sub) || left.contains(sub)) {
                return true;
            }
        }
        return false;
    }


    public int search(int L, int a, long modulus, int n, int[] nums) {
        long h = 0;
        for (int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;
        HashSet<Long> seen = new HashSet<>();
        seen.add(h);
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; start++) {

            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h)) return start;
            seen.add(h);
        }
        return -1;
    }


    public int longestDupSubstring(String S) {
        int n = S.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = (int) S.charAt(i) - (int) 'a';
        int a = 26;

        long modulus = (long) Math.pow(2, 32);

        int left = 1, right = n / 2;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1) left = L + 1;
            else right = L;
        }
        int start = search(left, a, modulus, n, nums);
        return start != -1 ? left : left - 1;
    }


    public static void main1(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        int left = 0;
        int or = 0;
        int pre = or;
        int res = n;
        for (int i = 0; i < n; i++) {
            or = or | A[i];
            if (or > pre) {
                int right = i;
                int temp = 0;
                while (left <= right && temp != or) {
                    temp = temp | A[right];
                    right--;
                }
                res = Math.min(i - right, res);
                left = right + 1;
            }
            pre = or;
        }
        System.out.println(res);*/
        //solution();
        System.out.println(Integer.parseInt("00001"));
    }


    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] route = new int[m][3];
        for (int i = 0; i < m; i++) {
            route[i][0] = in.nextInt();
            route[i][1] = in.nextInt();
            route[i][2] = combination(in.nextInt(), in.nextInt());
        }
        int res = 0;
        Arrays.sort(route, (o1, o2) -> (o2[2] - o1[2]));
        union = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            union[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int u = route[i][0];
            int v = route[i][1];
            if (findParent(u) != findParent(v)) {
                res = (res + route[i][2]) % mod;
                union(u, v);
            }
        }
        System.out.println(res);
    }

    static int[] union;
    static int mod = 1000000007;

    public static int findParent(int i) {
        while (union[i] != i) {
            i = union[i];
        }
        return i;
    }

    public static void union(int i, int j) {
        int ip = findParent(i);
        int jp = findParent(j);
        union[ip] = jp;
    }


    public static int combination(int a, int b) {
        b = Math.max(b, a - b);
        int A = 1;
        int B = 1;
        for (int i = a; i > b; i--) {
            A = (A * i) % mod;
        }
        for (int i = 1; i <= a - b; i++) {
            B = (B * i) % mod;
        }
        return A / B;
    }


}

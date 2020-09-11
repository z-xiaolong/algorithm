package exam;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author long
 * @Date 2020/4/18 18:57
 * @Title
 * @Description //TODO
 **/

public class JiDong {

    public static void main() {
        Scanner in = new Scanner(System.in);
        int MAX = 10000005;
        int n = in.nextInt();
        int m = in.nextInt();
        int cnt = 0;
        int[] prime = new int[MAX];
        boolean[] pp = new boolean[MAX];
        int[] vis = new int[MAX];
        if (m > 10000000) {
            m = 10000000;
        }
        for (int i = 2; i <= m; i++) {
            if (vis[i] == 0) {
                prime[cnt++] = i;
                pp[i] = true;
            }
            for (int j = 0; j < cnt && i * prime[j] <= m; j++) {
                vis[i * prime[j]] = i;
                if (i % prime[j] == 0) break;
            }
        }
        int sum = 0;
        for (int i = n; i <= m; i++) {
            if (isPara(i) && pp[i]) sum++;
        }
        System.out.println(sum);

    }

    public static boolean isPara(int x) {
        int y = x;
        int num = 0;
        while (y != 0) {
            num = num * 10 + y % 10;
            y /= 10;
        }
        return num == x;
    }

    public static void compute(int n) {
        BigDecimal num = new BigDecimal("0");
        for (int i = 1; i <= n; i++) {
            BigDecimal a = new BigDecimal("2");
            a = a.multiply(new BigDecimal(i)).subtract(new BigDecimal("1.0"));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double res = 0.0;
        double[] dp = new double[n + 1];
        for (int i = 1; i <= n; i++) {

        }
        res = res * 0.2;
        char[] num = new char[6];
        num[0] = '0';
        num[1] = '.';
        String s = String.valueOf(res);
        int i = 2;
        while (i < num.length) {
            if (i < s.length()) {
                num[i] = s.charAt(i);
            } else {
                num[i] = '0';
            }
            i++;
        }
        if (s.length() > 6) {
            char c = s.charAt(6);
            if (c >= '5') {
                num[5]++;
            }
        }
        System.out.println(new String(num));
    }

    public static boolean check(int[][] rectangles, int index) {
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < index + 6; i++) {
            set.add(rectangles[i][0]);
            set.add(rectangles[i][1]);
        }
        if (set.size() > 3) return false;
        if (set.size() == 1) return true;
        Map<Integer, Integer> hashMap = new HashMap<>();
        if (set.size() == 3) {
            for (int i = index; i < index + 6; i++) {
                int x = rectangles[i][0];
                int y = rectangles[i][1];
                if (x == y) return false;
                hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
                hashMap.put(y, hashMap.getOrDefault(y, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                int value = entry.getValue();
                if (value != 4) return false;
            }
        } else if (set.size() == 2) {
            int count = 0;
            for (int i = index; i < index + 6; i++) {
                int x = rectangles[i][0];
                int y = rectangles[i][1];
                if (x == y) count++;
            }
            if (count != 2) return false;
        }
        return true;
    }

}

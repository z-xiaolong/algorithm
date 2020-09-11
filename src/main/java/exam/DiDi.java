package exam;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/21 19:39
 * @Title
 * @Description:
 */
public class DiDi {

    public static void main(String[] args) {

        for (int i = 100; i < 2000; i++) {
            List<int[]> list = sum(i);
            if (list.size() > 0) {
                for (int[] num : list) {
                    System.out.print(num[0] + " " + num[1]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    public static List<int[]> sum(int n) {
        List<int[]> res = new ArrayList<>();
        for (int c = 0; c <= 9; c++) {
            for (int a = 1; a <= 9; a++) {
                int cc = c * 10 + c;
                int acc = a * 100 + cc;
                int abc = a * 100 + c;
                int b = (n - acc - abc) / 10;
                if (b >= 10 || b < 0) continue;
                abc = a * 100 + b * 10 + c;
                if (b != a && b != c && (abc + acc) == n) {
                    res.add(new int[]{abc, acc});
                }
            }
        }
        res.sort(Comparator.comparingInt(o -> o[0]));
        return res;
    }


    public static void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long[] fib = fibonacci(n * n);
        Arrays.sort(fib, Collections.reverseOrder());
        Long[][] res = new Long[n][n];
        int index = 0;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bot = n - 1;
        while (left <= right && top <= bot) {
            for (int c = left; c <= right; c++) {
                res[top][c] = fib[index];
                index++;
            }
            for (int r = top + 1; r <= bot; r++) {
                res[r][right] = fib[index];
                index++;
            }
            if (left < right && top < bot) {
                for (int c = right - 1; c > left; c--) {
                    res[bot][c] = fib[index];
                    index++;
                }
                for (int r = bot; r > top; r--) {
                    res[r][left] = fib[index];
                    index++;
                }
            }
            left++;
            right--;
            top++;
            bot--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n - 1) System.out.print(res[i][j] + " ");
                else System.out.print(res[i][j]);
            }
            if (i != n - 1) System.out.println();
        }

    }


    public static Long[] fibonacci(int n) {

        if (n < 1) return null;
        Long[] fib = new Long[n];
        if (n == 1) {
            fib[0] = 1L;
            return fib;
        }
        fib[0] = 1L;
        fib[1] = 1L;
        if (n == 2) {
            return fib;
        }
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
}

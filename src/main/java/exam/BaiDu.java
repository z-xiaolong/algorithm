package exam;

import java.util.Map;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/3/29 18:56
 * @Title
 * @Description //TODO
 **/

public class BaiDu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long max = lcm(n, n - 1) - gcd(n, n - 1);
        System.out.println(max);
    }

    public static long gcd(long a, long b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        } else {
            return gcd(a, b - a);
        }
    }

    public static long lcm(long a, long b) {
        long gcd = gcd(a, b);
        return a * b / gcd;
    }
}

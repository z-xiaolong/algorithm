package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/8/27 20:23
 * @Title
 * @Description:
 */
public class Jibite {

    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int N = in.nextInt();
        int xa = in.nextInt();
        int ya = in.nextInt();
        int xb = in.nextInt();
        int yb = in.nextInt();
        int xc = in.nextInt();
        int yc = in.nextInt();
        long A = x % mod;
        long B = y % mod;
        long C = z % mod;
        for (int i = 0; i < N; i++) {
            long a = (xb * B + xc * C) % mod;
            long tempA = (A + a) % mod;
            long b = (xa * A + yc * C) % mod;
            long tempB = (B + b) % mod;
            long c = (ya * A + yb * B) % mod;
            long tempC = (C + c) % mod;
            A = tempA;
            B = tempB;
            C = tempC;
        }
        System.out.print(A + " " + B + " " + C);
    }

    public static void solution1() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.toLowerCase();
        String[] strings = str.split(" ");
        str = strings[0];
        char c1 = strings[1].charAt(0);
        char c2 = strings[2].charAt(0);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c1) list1.add(i);
            if (str.charAt(i) == c2) list2.add(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i : list1) {
            for (int j : list2) {
                max = Math.max(max, Math.abs(i - j));
            }
        }
        if (max > 0) {
            System.out.println(max);
        } else {
            System.out.println(-1);
        }
    }


    public static void solution2() {

    }
}

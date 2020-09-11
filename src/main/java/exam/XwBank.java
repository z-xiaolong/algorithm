package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/9/5 15:26
 * @Title
 * @Description:
 */
public class XwBank {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] apples = new int[n];
            for (int j = 0; j < n; j++) {
                apples[j] = in.nextInt();
            }
            System.out.println(sub(apples));
        }
    }

    public static int sub(int[] apples) {
        Arrays.sort(apples);
        int sub = Integer.MAX_VALUE;
        for (int i = 1; i < apples.length; i++) {
            sub = Math.min(sub, apples[i] - apples[i - 1]);
            if (sub == 0) return 0;
        }
        return sub;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int x = in.nextInt();
            int odd = 0;//奇数
            int even = 0;//偶数
            for (int j = 0; j < n; j++) {
                if (in.nextInt() % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            if (check(odd, even, x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean check(int odd, int even, int x) {
        if (even == 0 && x % 2 == 0) return false;
        int i = 1;
        while (i <= odd) {
            if (even + i >= x) return true;
            i += 2;
        }
        return false;
    }

    public static boolean check(int[] apples, int x) {
        int odd = 0;//奇数
        int even = 0;//偶数
        for (int apple : apples) {
            if (apple % 2 == 0) even++;
            else odd++;
        }
        if (even == 0 && x % 2 == 0) return false;
        int i = 1;
        if (x == apples.length) return odd % 2 != 0;
        while (i <= odd) {
            if (even + i >= x) return true;
            i += 2;
        }
        return false;
    }
}

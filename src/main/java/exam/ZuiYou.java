package exam;

import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/9/10 19:17
 * @Title
 * @Description:
 */
public class ZuiYou {

    static final String MAX_VALUE = "9223372036854775807";
    static final String MIN_VALUE = "-9223372036854775807";

    static final int BASE = 36;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        num = num.toLowerCase();
        if ("".equals(num)) {
            System.out.println(0);
            return;
        }
        long res = 0;
        int power = num.length() - 1;
        boolean isNegative = false;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            long number = 0;
            if (c >= 'a' && c <= 'z') {
                number = c - 'a' + 10;
            } else if (c >= '0' && c <= '9') {
                number = c - '0';
            } else if (c == '-' || c == '+') {
                if (i != 0) {
                    System.out.println(0);
                    return;
                }
                if (c == '-') isNegative = true;
            } else {
                System.out.println(0);
                return;
            }
            res = (long) (res + number * Math.pow(BASE, power));
            power--;
        }
        System.out.println(getNum(String.valueOf(res), isNegative));
    }




    public static String getNum(String num, boolean isNegative) {
        if (num.length() > MAX_VALUE.length()) {
            if (isNegative) return MIN_VALUE;
            else return MAX_VALUE;
        } else if (num.length() == MAX_VALUE.length()) {
            int length = num.length();
            int i = 0;
            int j = 0;
            while (i < length && j < length) {
                char a = num.charAt(i);
                char b = MAX_VALUE.charAt(j);
                if (a > b) {
                    if (isNegative) return MIN_VALUE;
                    else return MAX_VALUE;
                }
                i++;
                j++;
            }
        }
        if (isNegative) return "-" + num;
        else return num;
    }


    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        num = num.toLowerCase();
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        boolean isNegative = false;
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int number = carry;
            if (c >= 'a' && c <= 'z') {
                number += c - 'a' + 10;
            } else if (c >= '0' && c <= '9') {
                number += c - '0';
            } else if (c == '-' || c == '+') {
                if (i != 0) {
                    System.out.println(0);
                    return;
                }
                if (c == '-') {
                    isNegative = true;
                }
                break;
            } else {
                System.out.println(0);
                return;
            }
            builder.append(number % 10);
            carry = number / 10;
        }
        builder.reverse();
        System.out.println(getNum(builder.toString(), isNegative));
    }




    public static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n + 1];
        if (n == 1 || n == 0) {
            System.out.println(n);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        System.out.println(dp[n]);
    }
}

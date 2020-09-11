package exam;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/7/29 14:15
 * @Title
 * @Description:
 */
public class Shopee {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(",");
        String v1 = strs[0];
        String v2 = strs[1];
        System.out.println(compare(v1, v2));
    }

    public static int compare(String v1, String v2) {
        String[] str1 = v1.split("\\.");
        String[] str2 = v2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < str1.length && j < str2.length) {
            int num1 = Integer.parseInt(str1[i]);
            int num2 = Integer.parseInt(str2[j]);
            if (num1 != num2) {
                if (num1 > num2) return 1;
                else return -1;
            }
            i++;
            j++;
        }
        while (i < str1.length) {
            int num = Integer.parseInt(str1[i]);
            if (num > 0) return 1;
            i++;
        }
        while (j < str2.length) {
            int num = Integer.parseInt(str2[j]);
            if (num > 0) return -1;
            j++;
        }
        return 0;
    }


    public static int compareInt(String num1, String num2) {
        return 0;
    }

    public static int longest(String s) {
        if (s == null) return 0;
        if (s.length() < 2) {
            return s.length();
        }
        int len = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                    }
                }
            }
        }
        return maxLen;
    }


    public static void solution() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        int[] nodes = new int[strs.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Integer.parseInt(strs[i]);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            if (nodes[i] < nodes[i + 1]) {
                System.out.print(nodes[i] + " ");
            }
        }
        System.out.print(nodes[nodes.length - 1]);
    }

    public static String getNum(String num, int n) {
        String temp = num;
        int i = 0;
        while (!"0".equals(temp) && !isOdd(temp)) {
            temp = divide(temp);
            i++;
        }
        while (!"0".equals(temp) && isOdd(temp)) {
            temp = divide(temp);
            i++;
        }
        if (i > n) return "0";
        return sub(add(num, i), i - 1);
    }

    public static String add(String num, int i) {
        String n = String.valueOf(1 << i);
        StringBuilder builder = new StringBuilder();
        int j = num.length() - 1;
        int k = n.length() - 1;
        int carry = 0;
        while (j >= 0 && k >= 0) {
            int a = num.charAt(j) - '0';
            int b = n.charAt(k) - '0';
            int sum = a + b + carry;
            carry = sum / 10;
            builder.append(sum % 10);
            j--;
            k--;
        }
        while (j >= 0) {
            int a = num.charAt(j) - '0';
            int sum = a + carry;
            carry = sum / 10;
            builder.append(sum % 10);
            j--;
        }
        return builder.reverse().toString();
    }

    public static String sub(String num, int i) {
        String n = String.valueOf(1 << i);
        StringBuilder builder = new StringBuilder();
        int j = num.length() - 1;
        int k = n.length() - 1;
        int carry = 0;
        while (j >= 0 && k >= 0) {
            int a = num.charAt(j) - '0' - carry;
            int b = n.charAt(k) - '0';
            if (a >= b) {
                builder.append(a - b);
                carry = 0;
            } else {
                builder.append(a + 10 - b);
                carry = 1;
            }
            j--;
            k--;
        }
        while (j >= 0) {
            int a = num.charAt(j) - '0' - carry;
            builder.append(a);
            carry = 0;
            j--;
        }
        return builder.reverse().toString();
    }


    public static boolean isOdd(String num) {
        int n = num.length() - 1;
        int c = num.charAt(n) - '0';
        return c % 2 == 1;
    }

    public static String divide(String num) {
        int[] res = new int[num.length()];
        int carry = 0;
        int i = 0;
        while (i < num.length()) {
            char c = num.charAt(i);
            int n = c - '0' + carry * 10;
            carry = n % 2;
            res[i] = n / 2 + '0';
            i++;
        }
        i = 0;
        while (i < res.length && res[i] == '0') i++;
        if (i == res.length) return "0";
        return new String(res, i, res.length - i);
    }


    @Test
    public void test() {
        System.out.println(isOdd("1112"));
        System.out.println(add("1234", 5));
        System.out.println(sub("1234", 3));
    }


    public static int[] solution(int[] books, int[] acmers) {
        Arrays.sort(books);
        boolean[] flag = new boolean[books.length];
        int[] res = new int[acmers.length];
        for (int i = 0; i < acmers.length; i++) {
            int index = binarySearch(books, acmers[i]);
            if (index == books.length) {
                res[i] = -1;
            } else if (!flag[index] && books[index] >= acmers[i]) {
                res[i] = books[index];
                flag[index] = true;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    public static int binarySearch(int[] books, int acmer) {
        int left = 0;
        int right = books.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (books[mid] < acmer) {
                left = mid + 1;
            } else if (books[mid] >= acmer) {
                right = mid;
            }
        }
        return left;
    }
}

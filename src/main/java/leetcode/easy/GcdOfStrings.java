package leetcode.easy;

import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/12 10:41
 * @Title 1071. 字符串的最大公因子
 * @Description //TODO
 **/

public class GcdOfStrings {

    public static void main(String[] args) {
        int a = 24;
        int b = 12;
        System.out.println(gcd(a, b));
    }


    //数学方法  str1 + str2 == str2 + str1 就可证明得到 时间复杂度实际和下面方法一样
    //执行用时 :1 ms, 在所有 Java 提交中击败了93.98%的用户
    public String gcdOfStrings(String str1, String str2) {
        int gcd = gcd(str1.length(), str2.length());
        if ((str1 + str2).equals(str2 + str1)) {
            return str1.substring(0, gcd);
        }
        return "";
    }

    //执行用时 :4 ms, 在所有 Java 提交中击败了28.01%的用户
    //改为equals后：执行用时 :1 ms, 在所有 Java 提交中击败了93.98%的用户
    public String gcdOfStringsI(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int gcd = gcd(length1, length2);
        String gcdString = str1.substring(0, gcd);
        for (int i = 0; i < length1; i = i + gcd) {
            if (!gcdString.equals(str1.substring(i, i + gcd))) {
                return "";
            }
        }
        for (int i = 0; i < length2; i = i + gcd) {
            if (!gcdString.equals(str2.substring(i, i + gcd))) {
                return "";
            }
        }
/*        for (int i = 0; i < length1; i++) {
            if (gcdString.charAt(i % gcd) != str1.charAt(i)) {
                return "";
            }
        }
        for (int i = 0; i < length2; i++) {
            if (gcdString.charAt(i % gcd) != str2.charAt(i)) {
                return "";
            }
        }*/
        return gcdString;
    }

    public static int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (min != 0) {
            int temp = max % min;
            max = min;
            min = temp;
        }
        return max;
    }
}

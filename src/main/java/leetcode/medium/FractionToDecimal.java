package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/10/3 16:26
 * @Title
 * @Description //TODO
 **/

public class FractionToDecimal {


    public static String fractionToDecimal(int numerator, int denominator) {
        String sign = "";
        long num = numerator;
        long den = denominator;
        if (num * den < 0) {
            sign = "-";
            num = -num;
        }
        long remainder = num % den;
        String integer = String.valueOf(num / den);
        if (remainder == 0) return sign + integer;
        StringBuilder builder = new StringBuilder();
        Map<Long, Integer> set = new HashMap<>();
        int index = 0;
        while (!set.containsKey(remainder) && remainder != 0) {
            set.put(remainder, index++);
            remainder *= 10;
            builder.append(remainder / den);
            remainder = remainder % den;
        }
        if (remainder == 0) {
            return sign + integer + "." + builder;
        }
        int insert = set.get(remainder);
        builder.insert(insert, '(');
        builder.append(')');
        return sign + integer + "." + builder;
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');//97
        System.out.println((int) 'A');//65
    }

    public String licenseKeyFormatting(String s, int k) {
        int n = s.length();
        int cnt = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                builder.append(Character.toUpperCase(c));
            }
            if (cnt == k) {
                builder.append('-');
                cnt = 0;
            }
        }
        if (builder.length() > 0 && cnt == 0)
            builder.deleteCharAt(builder.length() - 1);
        return builder.reverse().toString();
    }
}

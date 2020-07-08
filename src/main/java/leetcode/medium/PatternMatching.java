package leetcode.medium;

/**
 * @Author long
 * @Date 2020/6/22 9:04
 * @Title
 * @Description //TODO
 **/

public class PatternMatching {

    public boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0) return value.length() == 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') a++;
            if (pattern.charAt(i) == 'b') b++;
        }
        if (value.length() == 0) {
            return !(a > 0 && b > 0);
        }
        int n = value.length();
        if (a == 0) {
            return n % b == 0 && check(pattern, value, 0, n / b);
        }
        if (b == 0) {
            return n % a == 0 && check(pattern, value, n / a, 0);
        }
        for (int i = 0; i <= n / a; i++) {
            int countB = n - a * i;
            if (countB % b == 0) {
                if (check(pattern, value, i, countB / b))
                    return true;
            }
        }
        return false;
    }

    public boolean check(String pattern, String value, int a, int b) {
        String strA = null;
        String strB = null;
        for (int i = 0, j = 0; i < pattern.length() && j < value.length(); i++) {
            char c = pattern.charAt(i);
            if (c == 'a') {
                if (j + a > value.length()) return false;
                String temp = value.substring(j, j + a);
                if (strA == null) {
                    strA = temp;
                } else {
                    if (!strA.equals(temp))
                        return false;
                }
                j += a;
            } else if (c == 'b') {
                if (j + b > value.length()) return false;
                String temp = value.substring(j, j + b);
                if (strB == null) {
                    strB = temp;
                } else {
                    if (!strB.equals(temp))
                        return false;
                }
                j += b;
            }
        }
        return true;
    }
}

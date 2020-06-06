package leetcode.medium;

import leetcode.hard.KMP;

/**
 * @Author long
 * @Date 2020/5/28 9:23
 * @Title 394. 字符串解码
 * @Description //TODO
 **/

public class DecodeString {

    public static void main(String[] args) {
        decodeString("3[a2[c]]");
    }

    public static String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        int left = 0;
        int length = s.length();
        while (left < length && !isDigit(s.charAt(left))) {
            builder.append(s.charAt(left));
            left++;
        }
        int k = 0;
        while (left < length && isDigit(s.charAt(left))) {
            k = k * 10 + (s.charAt(left) - '0');
            left++;
        }
        int right = ++left + 1;
        int count = 1;
        while (right < length && count != 0) {
            if (s.charAt(right) == '[') count++;
            if (s.charAt(right) == ']') count--;
            right++;
        }
        right--;
        if (right < length) {
            String subStr = decodeString(s.substring(left, right));
            for (int i = 0; i < k; i++) {
                builder.append(subStr);
            }
            subStr = decodeString(s.substring(right + 1));
            builder.append(subStr);
        }
        return builder.toString();
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}

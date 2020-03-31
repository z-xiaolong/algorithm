package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/16 10:05
 * @Title 面试题 01.06. 字符串压缩
 * @Description //TODO
 **/

public class CompressString {

    //双指针
    public String compressString(String S) {
        int length = S.length();
        if (length == 0) {
            return S;
        }
        int left = 0;
        int right = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (right < length) {
            while (right < length && S.charAt(left) == S.charAt(right)) {
                right++;
            }
            stringBuilder.append(S.charAt(left));
            stringBuilder.append(right - left);
            left = right;
        }
        if (stringBuilder.length() >= length) {
            return S;
        }
        return stringBuilder.toString();
    }


    //暴力遍历
    public String compressStringI(String S) {
        int length = S.length();
        if (length == 0) {
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                stringBuilder.append(S.charAt(i - 1));
                stringBuilder.append(count);
                count = 1;
            } else {
                count++;
            }
        }
        stringBuilder.append(S.charAt(length - 1));
        stringBuilder.append(count);
        if (stringBuilder.length() >= length) {
            return S;
        }
        return stringBuilder.toString();
    }
}

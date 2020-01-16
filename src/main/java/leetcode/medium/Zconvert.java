package leetcode.medium;

/**
 * @author long
 */
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
public class Zconvert {

    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuffer buffer = new StringBuffer();
        char[] chars = new char[s.length()];
        int len = numRows * 2 - 2;
        for (int j = 0; j < s.length(); j++) {
            if (j % len == 0) {
                chars[j / len] = s.charAt(j);
            } else if (j % len == 1 || j % len == len - 1) {
                //TODO
            }
        }
        return "";
    }
}

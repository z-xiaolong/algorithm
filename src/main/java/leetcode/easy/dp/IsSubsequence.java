package leetcode.easy.dp;

/**
 * @Author long
 * @Date 2020/2/17 15:22
 * @Title 392. 判断子序列
 * @Description 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），
 * 而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）
 * 字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 **/

public class IsSubsequence {


    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }

    public int indexOf(String str, char c, int index) {
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    //遍历
    public static boolean isSubsequence1(String s, String t) {
        int sub = s.length();
        int str = t.length();
        int i = 0;
        int j = 0;
        while (i < sub && j < str) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == sub;
    }
}

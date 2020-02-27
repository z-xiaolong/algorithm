package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/26 19:24
 * @Title 14. 最长公共前缀
 * @Description 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 **/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if (size == 0) return "";
        if (size == 1) return strs[0];
        char c;
        int index = 0;
        while (index < strs[0].length()) {
            c = strs[0].charAt(index);
            for (int j = 1; j < strs.length; j++) {
                if (!check(strs[j], index, c)) {
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
        return strs[0];
    }

    public boolean check(String str, int index, char c) {
        if (str.length() > index && str.charAt(index) == c) {
            return true;
        }
        return false;
    }

    public String longestCommonPrefixI(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String s1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(s1) != 0) {
                s1 = s1.substring(0, s1.length() - 1);
            }
        }
        return s1;
    }
}

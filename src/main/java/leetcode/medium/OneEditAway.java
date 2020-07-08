package leetcode.medium;

/**
 * @Author long
 * @Date 2020/7/8 8:45
 * @Title 面试题 01.05. 一次编辑
 * @Description //TODO
 **/

public class OneEditAway {

    public boolean oneEditAway(String first, String second) {
        if (first.length() < second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }
        int n = first.length();
        int m = second.length();
        if (n - m >= 2) return false;
        if (n == m) {
            int i = 0;
            int count = 0;
            while (i < n) {
                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                    if (count >= 2) return false;
                }
                i++;
            }
        } else {
            int i = 0, j = 0;
            int count = 0;
            while (i < n && j < m) {
                if (first.charAt(i) != second.charAt(j)) {
                    count++;
                    i++;
                    if (count >= 2) return false;
                    continue;
                }
                i++;
                j++;
            }
        }
        return true;
    }
}

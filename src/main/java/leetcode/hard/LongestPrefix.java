package leetcode.hard;

/**
 * @Author long
 * @Date 2020/3/22 13:46
 * @Title 5367. 最长快乐前缀
 * @Description KMP 的里求next的问题
 **/

public class LongestPrefix {

    public static void main(String[] args) {
        LongestPrefix longestPrefix = new LongestPrefix();
        longestPrefix.longestPrefix("acccbaaacccbaac");
    }

    //执行用时 :11 ms, 在所有 Java 提交中击败了100.00%的用户
    public String longestPrefix(String s) {
        int length = s.length();
        int[] next = new int[length];
        for (int j = 1, i = 0; j < length && i < length; ) {
            if (s.charAt(i) == s.charAt(j)) {
                next[j] = i + 1;
                i++;
                j++;
            } else if (i != 0) {
                i = next[i - 1];
            } else {
                next[j] = 0;
                j++;
            }
        }
        return s.substring(0, next[length - 1]);
    }


}

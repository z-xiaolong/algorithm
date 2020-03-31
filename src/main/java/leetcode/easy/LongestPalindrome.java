package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/19 10:19
 * @Title 409. 最长回文串
 * @Description //TODO
 **/

public class LongestPalindrome {

    //优化后：执行用时 :2 ms, 在所有 Java 提交中击败了76.48%的用户
    public int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] chars = new int[58];
        for (char c : s.toCharArray()) {
            chars[c - 'A']++;
        }
        int count = 0;
        int odd = 0;
        for (int num : chars) {
            count += num / 2 * 2;
            if (num % 2 == 1) {
                odd = 1;
            }
        }
        return count + odd;
    }

    //执行用时 :2 ms, 在所有 Java 提交中击败了76.48%的用户
    public int longestPalindromeI(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] charsLower = new int[26];
        int[] charsUpper = new int[26];
        for (char c : s.toCharArray()) {
            if (c - 'a' >= 0) {
                charsLower[c - 'a']++;
            } else {
                charsUpper[c - 'A']++;
            }
        }
        int singular = 0;
        int count = 0;
        for (int num : charsLower) {
            if (num % 2 == 0) {
                count += num;
            } else {
                count += num - 1;
                singular++;
            }
        }
        for (int num : charsUpper) {
            if (num % 2 == 0) {
                count += num;
            } else {
                count += num - 1;
                singular++;
            }
        }
        if (singular > 0) {
            count++;
        }
        return count;
    }
}

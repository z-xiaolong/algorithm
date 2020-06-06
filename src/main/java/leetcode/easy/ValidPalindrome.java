package leetcode.easy;

/**
 * @Author long
 * @Date 2020/5/19 9:01
 * @Title 680. 验证回文字符串 Ⅱ
 * @Description //TODO
 **/

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }
        if (left + 1 == right) return true;
        return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
    }

    public boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}

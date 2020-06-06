package leetcode.easy;

/**
 * @Author long
 * @Date 2020/4/27 11:23
 * @Title 125. 验证回文串
 * @Description //TODO
 **/

public class IsPalindrome {

    //执行用时 :5 ms, 在所有 Java 提交中击败了62.43%的用户
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !check(s.charAt(left))) {
                left++;
            }
            while (left < right && !check(s.charAt(right))) {
                right--;
            }
            if (left != right && s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean check(char c) {
        if (c >= '0' && c <= '9') return true;
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }
}

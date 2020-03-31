package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/10 10:40
 * @Title 344. 反转字符串
 * @Description //TODO
 **/

public class ReverseString {


    //执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            if (s[left] != s[right]) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
            }
            left++;
            right--;
        }
    }
}

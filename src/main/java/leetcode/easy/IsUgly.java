package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/20 11:08
 * @Title
 * @Description 丑数就是只包含质因数 2, 3, 5 的正整数。
 **/

public class IsUgly {

    //执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
}

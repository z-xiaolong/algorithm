package leetcode.easy;

/**
 * @Author long
 * @Date 2020/5/9 9:28
 * @Title 367. 有效的完全平方数
 * @Description //TODO
 **/

public class IsPerfectSquare {
    public static void main(String[] args) {
        isPerfectSquare(808201);
    }

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long left = 1;
        long right = num >> 1;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (mid * mid > num) {
                right = mid - 1;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

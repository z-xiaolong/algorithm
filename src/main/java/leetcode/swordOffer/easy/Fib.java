package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/1 21:42
 * @Title 面试题10- I. 斐波那契数列
 * @Description //TODO
 **/

public class Fib {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        long temp;
        long first = 0;
        long second = 1;
        while (n >= 2) {
            temp = second;
            second = (first + temp) % 1000000007;
            first = temp;
            n--;
        }
        return (int) (second % 1000000007);
    }

    public int fibI(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}

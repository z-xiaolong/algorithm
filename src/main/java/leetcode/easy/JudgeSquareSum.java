package leetcode.easy;

/**
 * @Author long
 * @Date 2020/5/9 9:37
 * @Title 633. 平方数之和
 * @Description //TODO
 **/

public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }

    //暴力法: 超时
    public static boolean judgeSquareSumI(int c) {
        if (c == 0) return true;
        long a = 0;
        long b = c >> 1;
        while (a <= b) {
            if (a * a + b * b < c) {
                a++;
            } else if (a * a + b * b > c) {
                b--;
            } else {
                return true;
            }
        }
        System.out.println(a);
        return false;
    }
}

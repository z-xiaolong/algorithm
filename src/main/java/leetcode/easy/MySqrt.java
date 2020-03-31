package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/27 21:44
 * @Title 69. x 的平方根
 * @Description 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 **/

public class MySqrt {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        mySqrt.mySqrt(1312312323);
    }


    //牛顿法
    public int mySqrt(int x) {
        if (x < 2) return x;
        double x0 = x;
        double x1 = (x0 + x / x0) / 2.0;
        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2.0;
        }

        return (int) x1;
    }

    //二分 执行用时 :2 ms, 在所有 Java 提交中击败了81.70%的用户
    public int mySqrtII(int x) {
        long min = 1;
        long max = x / 2;
        long product;
        long mid = 1;
        while (min <= max) {
            mid = (min + max) / 2;
            product = mid * mid;
            if (product > x) {
                max = mid - 1;
            } else if (product < x) {
                min = mid + 1;
            } else if (product == x) {
                return (int) mid;
            }
        }
        if (mid * mid > x) {
            return (int) mid - 1;
        }
        return (int) mid;
    }

    //执行用时 :26 ms, 在所有 Java 提交中击败了7.42%的用户
    public int mySqrtI(int x) {
        int res = 1;
        int product = res * res;
        while (product <= x && product > 0) {
            res++;
            product = res * res;
        }
        return res - 1;
    }
}

package leetcode.medium;

/**
 * @Author long
 * @Date 2019/12/23 19:17
 * @Title 50. Pow(x, n)
 * @Description 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数
 **/

public class MyPow {
    public static void main(String[] args) {
        //System.out.println(myPow(2.10000, -2));
        System.out.println(Math.pow(2.10000, -2));
    }

    /**
     * create by long on 2019/12/23
     *
     * @return
     * @param: null
     * @description 暴力法，超时
     */
    public static double myPowViolence(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double k = x;
        for (int i = 0; i < Math.abs(n) - 1; i++) {
            x = x * k;
        }
        if (n < 0) {
            x = 1 / x;
        }
        return x;
    }

    //超时
    public static double myPowBinary(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        int mid = n / 2;
        return myPowBinary(x, mid) * myPowBinary(x, n - mid);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    //递归
    public double myPowRecursion(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
    //快速幂算法（循环）
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}

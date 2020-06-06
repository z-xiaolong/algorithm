package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/4/3 9:27
 * @Title 面试题16. 数值的整数次方
 * @Description //TODO
 **/

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(1, -2147483648));
    }


    //快速幂算法：执行用时 :1 ms, 在所有 Java 提交中击败了92.60%的用户
    public static double myPow(double x, int n) {
        long N = n;
        double res = 1.0;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        double cur = x;
        while (N != 0) {
            if ((N & 1) == 1) {
                res = res * cur;
            }
            cur = cur * cur;
            N = N >> 1;
        }
        return res;
    }

    //执行用时 :1 ms, 在所有 Java 提交中击败了92.60%的用户
    public static double myPowI(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }
        double res = 1;
        if (n % 2 == 0) {
            res = myPow(x, n / 2);
            res = res * res;
        } else if (n > 0) {
            res = myPow(x, n / 2);
            res = res * res * x;
        } else {
            res = myPow(x, n / 2);
            res = res * res / x;
        }
        return res;
    }


}

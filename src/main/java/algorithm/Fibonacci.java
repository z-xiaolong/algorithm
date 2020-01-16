package algorithm;

/**
 * @Author long
 * @Date 2019/11/27 21:49
 * @Title
 * @Description 斐波那契数列
 **/

public class Fibonacci {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(fib(64));
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
        System.out.println(fibonacci(64));
        startTime = System.currentTimeMillis();
        System.out.println("耗时：" + (startTime - endTime));
    }

    /**
     * create by long on 2019/11/27
     *
     * @return int
     * @param: n 第n个数
     * @description 递归方法
     */
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * create by long on 2019/11/27
     *
     * @return int
     * @param: n
     * @description
     */
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        while (n > 2) {
            int temp = a;
            a = a + b;
            b = temp;
            n--;
        }
        return a;
    }
}

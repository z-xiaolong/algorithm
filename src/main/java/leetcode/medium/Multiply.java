package leetcode.medium;

/**
 * @Author: long
 * @Date: 2020/8/2 10:22
 * @Title 面试题 08.05. 递归乘法
 * @Description:
 */
public class Multiply {

    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int product = 0;
        while (min > 0) {
            if ((min & 1) == 1) {
                product += max;
            }
            max += max;
            min >>= 1;
        }
        return product;
    }

}

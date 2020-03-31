package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/3/6 18:13
 * @Title 面试题64. 求1+2+…+n
 * @Description 求 1+2+...+n ，要求不能使用乘除法、for、while、if、
 * else、switch、case等关键字及条件判断语句（A?B:C）。
 **/

public class SumNums {

    //递归
    public int sumNums(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}

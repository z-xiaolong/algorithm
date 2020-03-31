package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/5 21:46
 * @Title 面试题10- II. 青蛙跳台阶问题
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 **/

public class NumWays {


    //  O(1)内存
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int prv = 1;
        int next = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = next;
            next = (prv + next) % 1000000007;
            prv = temp;
        }
        return next;
    }

    public int numWaysI(int n) {
        if (n < 2) {
            return 1;
        }
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }
}

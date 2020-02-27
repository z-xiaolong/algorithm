package leetcode.easy.dp;

/**
 * @Author long
 * @Date 2020/2/16 17:45
 * @Title 面试题 08.01. 三步问题
 * @Description 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，
 * 小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 **/

public class WaysToStep {

    public int waysToStep(int n) {
        return dp(n);
    }

    public int dp(int n) {
        if (n < 3) {
            return n;
        }
        long[] ways = new long[3];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        while (n >= 3) {
            long temp = ways[0];
            ways[0] = ways[1];
            ways[1] = ways[2];
            ways[2] = (temp + ways[1] + ways[0]) % 1000000007;
            n--;
        }
        return (int) ways[2];
    }
}

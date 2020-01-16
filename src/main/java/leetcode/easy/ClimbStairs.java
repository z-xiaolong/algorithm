package leetcode.easy;


/*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
*/


/**
 * @author long
 */
public class ClimbStairs {
    public static int num = 0;

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        long startTime = System.currentTimeMillis();
        System.out.println(climbStairs.climbStairs(100000));
        long endTime = System.currentTimeMillis();
        System.out.println("分治：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        System.out.println(climbStairs.climbStairs_DP(100000));
        endTime = System.currentTimeMillis();
        System.out.println("动态规划：" + (endTime - startTime));
    }


    /**
     * create by long on 2019/11/20
     * @param: n
     * @return int
     * @description 递归，超出时间复杂度
    */
    public int climbStairs2(int n) {
        System.out.println("num: " + num++);
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int sum = climbStairs2(n - 1) + climbStairs2(n - 2);
        return sum;
    }

    //分治
    /**
     * create by long on 2019/11/20
     * @param: int
     * @return long
     * @description
    */
    public long climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n / 2) * climbStairs(n - n / 2) + climbStairs(n / 2 - 1) * climbStairs(n - (n / 2 + 1));
    }

    public long climbStairs_DP(int n) {
        if (n == 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

package leetcode.medium;

/**
 * @Author long
 * @Date 2020/4/23 9:41
 * @Title 面试题 08.11. 硬币
 * @Description //TODO
 **/

public class WaysToChange {

    public static void main(String[] args) {
        WaysToChange waysToChange = new WaysToChange();
        waysToChange.waysToChange(5);
    }

    //


    public int waysToChange(int n) {
        if (n == 0) return 1;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 5 == 0) {
                dp[i] += dp[i - 5] + 1;
            }
            if(i % 10 == 0 && i >=10){
                dp[i] = dp[i-10] + 1;
            }

        }

        return (int) (dp[n] % 1000000007);
    }

    long count = 0;
    int[] level = new int[]{1, 5, 10, 25};

    //回溯超时
    public void backtrack(int n, int index) {
        if (n < 0) return;
        if (index == 0 || n < 5) {
            count++;
            return;
        }
        for (int i = index; i >= 0; i--) {
            backtrack(n - level[i], i);
        }
    }


    public int waysToChangeI(int n) {
        if (n == 0) return 1;
        long five = 0;
        long ten = 0;
        long twentyFive = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                five++;
                if (i >= 10) ten++;
                if (i >= 25) twentyFive++;
            }
            if (i % 10 == 0) {
                ten++;
                if (i >= 25) twentyFive++;
            }
            if (i % 25 == 0) {
                twentyFive++;
            }
        }
        return (int) ((five + ten + twentyFive + 1) % 1000000007);
    }
}

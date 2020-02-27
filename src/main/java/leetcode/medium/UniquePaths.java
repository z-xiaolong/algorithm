package leetcode.medium;

/**
 * @Author long
 * @Date 2020/2/12 11:53
 * @Title 62. 不同路径
 * @Description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 **/

public class UniquePaths {

    public int sum = 0;

    public int uniquePaths(int m, int n) {
        return dynamic(m, n);
    }

    //动态规划
    public int dynamic(int m, int n) {
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j] + array[i][j - 1];
                }
            }
        }
        return array[m - 1][n - 1];
    }

    //公式法，排列组和
    public int formula(int m, int n) {
        int N = n + m - 2;
        int k = m - 1;
        long res = 1;
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int) res;
    }

    //递归, 超时
    public int recursion(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return recursion(m - 1, n) + recursion(m, n - 1);
    }

    //回溯法，超时
    public void backtrack(int m, int n) {
        if (m == 1 || n == 1) {
            sum++;
            return;
        }
        backtrack(m - 1, n);
        backtrack(m, n - 1);
    }


}

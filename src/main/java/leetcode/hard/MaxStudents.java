package leetcode.hard;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/1 12:55
 * @Title 1349. 参加考试的最大学生数
 * @Description //TODO
 **/

public class MaxStudents {


    public static void main(String[] args) {
        char[][] seats = new char[][]{{'#', '.', '#', '#', '.', '#'}, {'.', '#', '#', '#', '#', '.'}
                , {'#', '.', '#', '#', '.', '#'}};
        maxStudents(seats);
    }

    //dp[i][j] = max(dp[i-1][k]) k&j
    public static int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        int[] bit = new int[m];
        int len = 1 << n;
        for (int i = 0; i < m; i++) {
            char[] seat = seats[i];
            for (int j = 0; j < n; j++) {
                if (seat[j] == '#') {
                    bit[i] |= 1 << (n - j - 1);
                }
            }
        }
        int[][] dp = new int[m][len];
        for (int i = 0; i < len; i++) {
            if ((i & bit[0]) == 0 && (i & (i >> 1)) == 0) {
                dp[0][i] = Integer.bitCount(i); //初始化第一排
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < len; j++) { //j表示一行可能的安排情况
                if ((j & (j << 1)) == 0 //检查左右
                        && (j & bit[i]) == 0) { //检查桌位是否损坏
                    for (int k = 0; k < len; k++) { //k表示前一排的座位安排情况
                        if ((j & (k >> 1)) == 0  //检查前一排左上方
                                && (j & (k << 1)) == 0) { //检查前一排右上方
                            int cnt = Integer.bitCount(j);
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + cnt);
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[m - 1][i]);
        }
        return max;
    }


    //回溯法，超时
    public int maxStudentsI(char[][] seats) {
        return backtrack(0, seats, 0, 0);
    }

    public int backtrack(int count, char[][] seats, int i, int j) {
        if (j >= seats[0].length) {
            return backtrack(count, seats, i + 1, 0);
        }
        if (i >= seats.length) {
            return count;
        }
        if (check(seats, i, j)) {
            setSeats(seats, i, j);
            int max1 = backtrack(count + 1, seats, i, j + 2);
            reset(seats, i, j);
            int max2 = backtrack(count, seats, i, j + 1);
            return Math.max(max1, max2);
        }
        return backtrack(count, seats, i, j + 1);
    }

    public void reset(char[][] seats, int i, int j) {
        if (j + 1 < seats[0].length && seats[i][j + 1] == '0') {
            seats[i][j + 1] = '.';
        }
        if (j - 1 >= 0 && seats[i][j - 1] == '0') {
            seats[i][j - 1] = '.';
        }
        if (i - 1 >= 0 && j - 1 >= 0 && seats[i - 1][j - 1] == '0') {
            seats[i - 1][j - 1] = '.';
        }
        if (j + 1 < seats[0].length && i - 1 >= 0 && seats[i - 1][j + 1] == '0') {
            seats[i - 1][j + 1] = '.';
        }
    }

    public void setSeats(char[][] seats, int i, int j) {
        if (j + 1 < seats[0].length && seats[i][j + 1] == '.') {
            seats[i][j + 1] = '0';
        }
        if (j - 1 >= 0 && seats[i][j - 1] == '.') {
            seats[i][j - 1] = '0';
        }
        if (i - 1 >= 0 && j - 1 >= 0 && seats[i - 1][j - 1] == '.') {
            seats[i - 1][j - 1] = '0';
        }
        if (j + 1 < seats[0].length && i - 1 >= 0 && seats[i - 1][j + 1] == '.') {
            seats[i - 1][j + 1] = '0';
        }
    }

    public boolean check(char[][] seats, int i, int j) {
        if (seats[i][j] != '.') {
            return false;
        }
        if (j + 1 < seats[0].length && seats[i][j + 1] == '1') {
            return false;
        }
        if (j - 1 >= 0 && seats[i][j - 1] == '1') {
            return false;
        }
        if (i - 1 >= 0 && j - 1 >= 0 && seats[i - 1][j - 1] == '1') {
            return false;
        }
        if (j + 1 < seats[0].length && i - 1 >= 0 && seats[i - 1][j + 1] == '1') {
            return false;
        }
        return true;
    }
}

package leetcode.contest;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/4/25 14:57
 * @Title
 * @Description //TODO
 **/

public class Contest2 {

    public int expectNumber(int[] scores) {
        int[] nums = new int[1000010];
        for (int s : scores) {
            nums[s] = 1;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public int minTime(int[] time, int m) {
        int n = time.length;
        if (m >= n) return 0;
        int sum = 0;
        for (int t : time) {
            sum += t;
        }
        int left = 0;
        int right = sum;
        while (left < right) {
            int mid = (left + right) / 2;
            int days = getDay(time, mid);
            if (days <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int getDay(int[] times, int time) {
        int days = 0;
        int index = 0;
        while (index < times.length) {
            int sum = 0;
            int max = times[index];
            while (index < times.length && sum + times[index] - max <= time) {
                sum += times[index];
                if (index + 1 < times.length) max = Math.max(max, times[index + 1]);
                index++;
            }
            days++;
        }
        return days;
    }


    public int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
    }

    class Solution {
        public int minTime(int[] time, int m) {
            int n = time.length;
            int[][] state = new int[n][m];
            int max = time[0];
            int[] sum = new int[n + 1];//求出time矩阵的和向量
            sum[0] = 0;
            for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + time[i];
            for (int i = 1; i < n; i++) {
                if (max < time[i]) max = time[i];
                state[i][0] = sum[i + 1] - max;//初始化state矩阵
            }

            for (int i = 2; i < n; i++) {
                for (int j = 1; j < m && j < i; j++) {
                    int min = 10001;
                    for (int k = 0; k < i; k++) {
                        int tmp = max(state[k][j - 1], sum[i + 1] - sum[k + 1] - max(time, k + 1, i));
                        if (tmp < min) min = tmp;
                    }
                    state[i][j] = min;
                }
            }
            return state[n - 1][m - 1];
        }

        public int max(int a, int b) {
            if (a < b) return b;
            else return a;
        }

        public int max(int[] time, int a, int b) {
            int max = time[a];
            for (int i = a + 1; i <= b; i++) {
                if (max < time[i]) max = time[i];
            }
            return max;
        }
    }
}

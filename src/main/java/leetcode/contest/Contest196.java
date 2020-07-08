package leetcode.contest;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/7/5 10:14
 * @Title
 * @Description //TODO
 **/

public class Contest196 {


    //5452. 判断能否形成等差数列
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int dif = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != dif) return false;
        }
        return true;
    }


    //5453. 所有蚂蚁掉下来前的最后一刻
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = Integer.MIN_VALUE;
        for (int i : left) {
            max = Math.max(i, max);
        }
        for (int i : right) {
            max = Math.max(max, n - i);
        }
        return max;
    }


    //5454. 统计全 1 子矩形
    public int numSubmat(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    sum += num(mat, i, j);
                }
            }
        }
        return sum;
    }

    public int num(int[][] mat, int i, int j) {
        int r = mat.length;
        int c = mat[0].length;
        boolean[][] flag = new boolean[r][c];
        int sum = 0;
        int temp = j;
        while (temp < c && mat[i][temp] == 1) {
            flag[i][temp] = true;
            sum++;
            temp++;
        }
        for (int k = i + 1; k < r; k++) {
            temp = j;
            while (temp < c && mat[k][temp] == 1 && flag[k - 1][temp]) {
                flag[k][temp] = true;
                sum++;
                temp++;
            }
        }
        return sum;
    }


    //5455. 最多 K 次交换相邻数位后得到的最小整数
    public String minInteger(String num, int k) {
        char[] nums = num.toCharArray();
        int length = nums.length;
        if ((length + 1) * length / 2 + 1 < k) {
            Arrays.sort(nums);
            return String.valueOf(nums);
        }
        int i = 0;
        while (k > 0 && i < nums.length) {
            k = swap(nums, k, i);
            i++;
        }
        return new String(nums);
    }

    public int swap(char[] nums, int k, int i) {
        int min = i;
        for (int j = i + 1; j < nums.length && j - i <= k; j++) {
            if (nums[j] < nums[min]) min = j;
        }
        char value = nums[min];
        int j = min;
        while (j > i) {
            nums[j] = nums[j - 1];
            j--;
        }
        nums[i] = value;
        return k - (min - i);
    }

    public static void main(String[] args) {
        Contest196 contest = new Contest196();
        int[][] nums = new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        contest.numSubmat(nums);
    }
}

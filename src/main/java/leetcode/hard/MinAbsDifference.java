package leetcode.hard;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/10/10 20:01
 * @Title
 * @Description //TODO
 **/

public class MinAbsDifference {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        minAbsDifference(nums, -7);
    }


    public static int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int m = (nums.length + 1) / 2;
        int[] left = new int[1 << m];
        int[] right = new int[1 << (n - m)];
        int ans = Math.abs(goal);
        for (int i = 1; i < left.length; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    left[i] = left[i - (1 << j)] + nums[j];
                    break;
                }
            }
            ans = Math.min(ans, Math.abs(left[i] - goal));
            if (ans == 0) return 0;
        }
        for (int i = 1; i < right.length; i++) {
            for (int j = 0; j < n - m; j++) {
                if ((i & (1 << j)) != 0) {
                    right[i] = right[i - (1 << j)] + nums[j + m];
                    break;
                }
            }
            ans = Math.min(ans, Math.abs(right[i] - goal));
            if (ans == 0) return 0;
        }
        Arrays.sort(left, 1, left.length);
        Arrays.sort(right, 1, right.length);
        int i = 1;
        int j = right.length - 1;
        while (i < left.length && j > 0) {
            int num = left[i] + right[j];
            ans = Math.min(ans, Math.abs(num - goal));
            if (num > goal) {
                j--;
            } else if (num < goal) {
                i++;
            } else {
                return 0;
            }
        }
        return ans;
    }

}

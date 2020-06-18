package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/6/14 9:36
 * @Title 1300. 转变数组后最接近目标值的数组和
 * @Description //TODO
 **/

public class FindBestValue {

    public static void main(String[] args) {
        FindBestValue value = new FindBestValue();
        int[] nums = new int[]{2, 3, 5};
        value.findBestValue(nums, 11);
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] sums = new int[arr.length];
        sums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }
        int left = 0;
        int right = arr[arr.length - 1];
        while (left < right) {
            int mid = (left + right) >> 1;
            int sum = getSum(arr, sums, mid);
            if (sum < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == arr[arr.length - 1]) return left;
        int a = Math.abs(getSum(arr, sums, left) - target);
        int b = Math.abs(getSum(arr, sums, left + 1) - target);
        int c = Math.abs(getSum(arr, sums, left - 1) - target);
        if (a <= b && a < c) return left;
        else if (c <= b && c <= a) return left - 1;
        else if (b < a) return left + 1;
        return -1;
    }

    public int getSum(int[] arr, int[] sums, int mid) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int m = (left + right) >> 1;
            if (arr[m] > mid) {
                right = m;
            } else if (arr[m] <= mid) {
                left = m + 1;
            }
        }
        if (left == 0) return arr.length * mid;
        return sums[left - 1] + (arr.length - left) * mid;
    }
}

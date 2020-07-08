package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/6/29 11:49
 * @Title 1498. 满足条件的子序列数目
 * @Description //TODO
 **/

public class NumSubseq {

    public static void main(String[] args) {
        NumSubseq subseq = new NumSubseq();
        subseq.numSubseq(new int[]{5, 2, 4, 1, 7, 6, 8, 9}, 25);
    }

    int mod = (int) (1e9 + 7);

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long res = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (2 * nums[i] > target) break;
            right = binarySearch(nums, target, i, right);
            res = (res + pow(right - i)) % mod;
        }
        return (int) res;
    }

    //快速幂
    public long pow(int x) {
        long res = 1;
        long temp = 2;
        while (x > 0) {
            if ((x & 1) == 1) {
                res *= temp;
                res %= mod;
            }
            temp *= temp;
            temp %= mod;
            x >>= 1;
        }
        return res;
    }

    //二分查找
    public int binarySearch(int[] nums, int target, int left, int right) {
        int min = nums[left];
        while (left < right) {
            int mid = (left + right) >> 1;
            if (min + nums[mid] > target) {
                right = mid;
            } else if (min + nums[mid] <= target) {
                left = mid + 1;
            }
        }
        if (nums[left] + min <= target) return left;
        return left - 1;
    }
}

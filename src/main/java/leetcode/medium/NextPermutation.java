package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/4/16 10:34
 * @Title 31. 下一个排列
 * @Description //TODO
 **/

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{5, 4, 3, 2, 1});
    }


    //执行用时 :1 ms, 在所有 Java 提交中击败了99.63%的用户
    public void nextPermutation(int[] nums) {
        int length = nums.length - 1;
        if (length < 0) return;
        int lower = length - 1;
        while (lower >= 0 && nums[lower] >= nums[lower + 1]) {
            lower--;
        }
        int high = length;
        if (lower == -1) {
            reversal(nums, 0);
            return;
        }
        while (high > lower && nums[lower] >= nums[high]) {
            high--;
        }
        swap(nums, lower, high);
        reversal(nums, lower + 1);
    }

    public void reversal(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package leetcode.easy;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/7/23 10:46
 * @Title 453. 最小移动次数使数组元素相等
 * @Description //TODO
 **/

public class MinMoves {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int value : nums) {
            min = Math.min(min, value);
        }
        int count = 0;
        for (int num : nums) {
            count += num - min;
        }
        return count;
    }

    public static void main(String[] args) {
        MinMoves minMoves = new MinMoves();
        int[] nums = new int[]{203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656, -425653504, -212123143};
        minMoves.minMoves2(nums);
    }


    //找中位数
    public int minMoves2(int[] nums) {
        int n = nums.length - 1;
        int target = n >> 1;
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = split(nums, left, right);
            if (mid < target) {
                left = mid + 1;
            } else if (mid > target) {
                right = mid - 1;
            } else {
                break;
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(num - nums[target]);
        }
        return sum;
    }


    public int split(int[] nums, int left, int right) {
        if (left == right) return left;
        int mid = (left + right) >> 1;
        int flag = nums[mid];
        nums[mid] = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= flag) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= flag) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = flag;
        return left;
    }

    public int minMoves2I(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] left = new long[n];
        long[] right = new long[n];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + (nums[i] - nums[i - 1]) * i;
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (nums[i + 1] - nums[i]) * (n - i - 1);
        }
        long count = left[0] + right[0];
        for (int i = 1; i < n; i++) {
            count = Math.min(left[i] + right[i], count);
        }
        return (int) count;
    }


}

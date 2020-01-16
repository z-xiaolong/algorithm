package leetcode.easy;


/*给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。*/
public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = {-2, -3};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(array));
    }

    public int maxSubArray(int[] nums) {
        int max = maxArray(nums, 0, nums.length - 1);
        return max;
    }

    //分治
    public int maxArray(int[] array, int low, int high) {
        if (low == high) {
            return array[low];
        }
        int mid = (low + high) / 2;
        int left = maxArray(array, low, mid);
        int right = maxArray(array, mid + 1, high);
        int cross = maxCrossArray(array, low, high);
        if (left >= right && left >= cross) {
            return left;
        } else if (right >= left && right >= cross) {
            return right;
        } else {
            return cross;
        }
    }

    public int maxCrossArray(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            sum = sum + array[i];
            if (sum > max) {
                max = sum;
            }
        }
        sum = max;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + array[j];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }


    //动态规划: 正数增益
    public int findMaxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}

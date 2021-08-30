package leetcode.medium;

/**
 * @Author long
 * @Date 2020/2/12 10:45
 * @Title
 * @Description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 **/

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
            mid = -1;
        }
        if (mid == -1) {
            result[0] = -1;
            result[1] = -1;
        } else {
            left = mid;
            right = mid;
            while (left >= 0 && nums[left] == nums[mid]) {
                left--;
            }
            while (right <= nums.length - 1 && nums[right] == nums[mid]) {
                right++;
            }
            result[0] = left + 1;
            result[1] = right - 1;
        }
        return result;
    }

    //二分查找，递归
    public int binarySearch(int left, int right, int[] nums, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(left, mid - 1, nums, target);
        } else {
            return binarySearch(mid + 1, right, nums, target);
        }
    }
}

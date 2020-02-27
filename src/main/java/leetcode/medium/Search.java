package leetcode.medium;

/**
 * @Author long
 * @Date 2020/2/23 22:51
 * @Title 33. 搜索旋转排序数组
 * @Description //TODO
 **/

public class Search {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        search(nums, 2);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right == -1) {
            return -1;
        }
        if (nums[right] > nums[left]) {
            while (right >= left) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
        if (nums[right] > target) {
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    if (nums[mid] < nums[left]) {
                        right = mid;
                    } else if (nums[mid] > nums[right]) {
                        left = mid;
                    }
                } else if (nums[mid] < target) {
                    left = mid;
                } else {
                    return mid;
                }
            }
        } else if (nums[left] < target) {
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    if (nums[mid] < nums[right]) {
                        right = mid;
                    } else if (nums[mid] > nums[right]) {
                        left = mid;
                    }
                } else {
                    return mid;
                }
            }
        } else if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}

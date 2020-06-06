package leetcode.easy;

/**
 * @Author long
 * @Date 2020/4/27 11:02
 * @Title 704. 二分查找
 * @Description //TODO
 **/

public class Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
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
}

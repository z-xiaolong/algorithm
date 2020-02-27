package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/26 21:53
 * @Title 35. 搜索插入位置
 * @Description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 **/

public class SearchInsert {

    //二分查找
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        /*if (nums[right] < target) {
            return right;
        }*/
        while (left <= right) {   //等号可以保证插入序号正确
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}

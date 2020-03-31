package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/11 14:21
 * @Title 面试题53 - I. 在排序数组中查找数字 I
 * @Description 统计一个数字在排序数组中出现的次数。
 **/

public class Search {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        search(nums, 1);
    }

    //二分法 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right < 0) {
            return 0;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        while (left < nums.length && nums[left] == target) {
            left++;
        }
        return left - right;
    }
}

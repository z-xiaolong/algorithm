package leetcode.medium;

/**
 * @Author long
 * @Date 2020/5/5 15:56
 * @Title 寻找峰值
 * @Description //TODO
 **/

public class FindPeakElement {

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }
}

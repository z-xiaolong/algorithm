package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/10 10:59
 * @Title 面试题21. 调整数组顺序使奇数位于偶数前面
 * @Description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 **/

public class Exchange {

    //快排思想 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}

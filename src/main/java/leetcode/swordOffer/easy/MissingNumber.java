package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/10 11:59
 * @Title 面试题53 - II. 0～n-1中缺失的数字
 * @Description 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有
 * 且只有一个数字不在该数组中，请找出这个数字。
 **/

public class MissingNumber {

    //二分 O(logN) 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (right < 0) {
            return 0;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] != mid) {
                right = mid - 1;
            } else if (nums[mid] == mid) {
                left = mid;
            }
        }
        if (nums[left] == left) {
            return left + 1;
        }
        return left;
    }

    //暴力法: O(n) 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int missingNumberI(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return 0;
    }
}

package leetcode.easy;

/**
 * @Author long
 * @Date 11:13 2019/10/29
 * @Title 283. 移动零
 * @Description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 **/

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNumber++;
            } else if (zeroNumber != 0) {
                nums[i - zeroNumber] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public static void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            nums[index1] = nums[index1] ^ nums[index2];
            nums[index2] = nums[index1] ^ nums[index2];
            nums[index1] = nums[index1] ^ nums[index2];
        }
    }
}

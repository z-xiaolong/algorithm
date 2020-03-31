package leetcode.hard;

/**
 * @Author long
 * @Date 21:30 2019/10/26
 * @Title 41. 缺失的第一个正数
 * @Description 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 **/

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] < length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            nums[index1] = nums[index1] ^ nums[index2];
            nums[index2] = nums[index1] ^ nums[index2];
            nums[index1] = nums[index1] ^ nums[index2];
        }
    }

    public boolean findOne(int[] nums) {
        for (int i : nums) {
            if(i == 1){
                return true;
            }
        }
        return false;
    }

}

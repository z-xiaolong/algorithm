package leetcode.medium;

/**
 * @Author long
 * @Date 2019/12/29 15:24
 * @Title 55. 跳跃游戏
 * @Description 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 **/

public class CanJump {

    //超时
    public boolean canJump0(int[] nums) {
        return jump(nums, 0);
    }

    public boolean jump(int[] nums, int index) {
        if (nums[index] + index >= nums.length - 1) {
            return true;
        } else {
            boolean result;
            int value = nums[index];
            while (value > 0) {
                result = jump(nums, index + value);
                if (result) {
                    return true;
                }
                value--;
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int index = nums.length - 2;
        int flag;
        boolean result = false;
        while (index >= 0) {
            while (index >= 0 && nums[index] > 0) {
                index--;
                result = true;
            }
            flag = index;
            while (index >= 0 && nums[index] + index <= flag) {
                index--;
                result = false;
            }
        }
        return result;
    }

    //贪心算法
    public class Solution {
        public boolean canJump(int[] nums) {
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i] >= lastPos) {
                    lastPos = i;
                }
            }
            return lastPos == 0;
        }
    }
}

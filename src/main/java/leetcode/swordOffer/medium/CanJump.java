package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/4/17 9:41
 * @Title 55. 跳跃游戏
 * @Description //TODO
 **/

public class CanJump {

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        canJump.canJump(new int[]{3, 0, 0, 0});
    }

    //执行用时 :1 ms, 在所有 Java 提交中击败了99.93%的用户
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length <= 1) return true;
        int zeroIndex = length - 2;
        int index = zeroIndex;
        while (index >= 0) {
            while (zeroIndex >= 0 && nums[zeroIndex] != 0) {
                zeroIndex--;
            }
            if (zeroIndex == -1) return true;
            index = zeroIndex;
            while (index >= 0 && nums[index] + index <= zeroIndex) {
                index--;
            }
            if (index == -1) return false;
            zeroIndex = index;
        }
        return true;
    }

    //贪心算法
    public class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int rightmost = 0;
            for (int i = 0; i < n; ++i) {
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= n - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

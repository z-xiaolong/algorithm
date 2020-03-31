package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/1 19:48
 * @Title 面试题03. 数组中重复的数字
 * @Description
 **/

public class FindRepeatNumber {


    public int findRepeatNumber(int[] nums) {
        int[] array = new int[nums.length];
        for (int i : nums) {
            array[i]++;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 1) {
                return i;
            }
        }
        return 0;
    }
}

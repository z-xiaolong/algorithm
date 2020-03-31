package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/12 16:51
 * @Title 面试题39. 数组中出现次数超过一半的数字
 * @Description //TODO
 **/

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int count = 0;
        for (int num : nums) {
            if (num == majority) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                majority = num;
                count++;
            }
        }
        return majority;
    }
}

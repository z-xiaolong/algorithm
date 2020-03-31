package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/21 11:03
 * @Title 面试题61. 扑克牌中的顺子
 * @Description //TODO
 **/

public class IsStraight {

    //执行用时 :1 ms, 在所有 Java 提交中击败了87.13%的用户
    public boolean isStraight(int[] nums) {
        int[] arr = new int[14];
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 1) {
                return false;
            }
        }
        int left = 1;
        int right = 13;
        while (left < right && arr[left] == 0) {
            left++;
        }
        while (left < right && arr[right] == 0) {
            right--;
        }
        return (right - left + 1) <= 5;
    }
}

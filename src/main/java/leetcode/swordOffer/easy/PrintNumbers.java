package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/6 18:07
 * @Title 面试题17. 打印从1到最大的n位数
 * @Description //TODO
 **/

public class PrintNumbers {
    public int[] printNumbers(int n) {
        int length = (int) Math.pow(10, n);
        int[] nums = new int[length - 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}

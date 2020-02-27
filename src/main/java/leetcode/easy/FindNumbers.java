package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/23 22:29
 * @Title 1295. 统计位数为偶数的数字
 * @Description 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 **/

public class FindNumbers {

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (isNumber(num)) {
                count++;
            }
        }
        return count;
    }

    public boolean isNumber(int num) {
        int length = String.valueOf(num).length();
        return length % 2 == 0;
    }

    public boolean isNumber1(int num) {
        int count = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count % 2 == 0;
    }
}

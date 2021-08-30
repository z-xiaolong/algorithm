package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/4/12 14:10
 * @Title
 * @Description //TODO
 **/

public class LargestNumber {

    public String largestNumber(int[] nums) {
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums, (a, b) -> {
            long x = 10;
            long y = 10;
            while (x <= a) {
                x *= 10;
            }
            while (y <= b) {
                y *= 10;
            }
            return (int) (b * x + a - a * y - b);
        });
        if (newNums[0] == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int num : newNums) {
            builder.append(num);
        }
        return builder.toString();
    }
}

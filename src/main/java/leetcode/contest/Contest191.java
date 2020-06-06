package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2020/5/31 10:28
 * @Title
 * @Description //TODO
 **/

public class Contest191 {

    //5424. 数组中两元素的最大乘积
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        if (nums[1] < 0) {
            max = Math.max(max, (nums[0] - 1) * (nums[1] - 1));
        }
        int n = nums.length;
        max = Math.max(max, (nums[n - 1] - 1) * (nums[n - 2] - 1));
        return max;
    }


    //5425. 切割后面积最大的蛋糕
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long high = horizontalCuts[0];
        long wide = verticalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            high = Math.max(high, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        high = Math.max(high, h - horizontalCuts[horizontalCuts.length - 1]);

        for (int i = 1; i < verticalCuts.length; i++) {
            wide = Math.max(wide, verticalCuts[i] - verticalCuts[i - 1]);
        }
        wide = Math.max(wide, w - verticalCuts[verticalCuts.length - 1]);
        long res = high * wide;
        return (int) (res % 1000000007);
    }


    //5426. 重新规划路线
    public int minReorder(int n, int[][] connections) {

        return 0;
    }

    public static void main(String[] args) {

    }
}

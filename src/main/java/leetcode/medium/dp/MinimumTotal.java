package leetcode.medium.dp;

import java.util.List;

/**
 * @Author long
 * @Date 2020/2/22 17:39
 * @Title 120. 三角形最小路径和
 * @Description 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 **/

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] nums = new int[length + 1];
        List<Integer> list;
        for (int i = length - 1; i >= 0; i--) {
            list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                nums[j] = Math.min(nums[j], nums[j + 1]) + list.get(j);
            }
        }
        return nums[0];
    }
}

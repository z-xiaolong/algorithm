package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2019/12/29 14:28
 * @Title 46. 全排列
 * @Description 给定一个没有重复数字的序列，返回其所有可能的全排列。
 **/

public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> output = permute.permute(nums);
        for (List list : output) {
            System.out.println(list.toString());
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        ArrayList<Integer> numsList = new ArrayList<Integer>();
        for (Integer i : nums) {
            numsList.add(i);
        }
        int n = nums.length;
        backtrack(n, numsList, output, 0);
        return output;
    }

    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n) {
            output.add(new ArrayList<Integer>(nums));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }
}

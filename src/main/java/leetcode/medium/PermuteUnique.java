package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/2/20 10:09
 * @Title 47. 全排列 II
 * @Description 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 **/

public class PermuteUnique {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 0, 3};
        PermuteUnique permuteUnique = new PermuteUnique();
        permuteUnique.permuteUnique(nums);
        //TODO
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int num : nums) {
            list.add(num);
        }
        backtrack(output, list, nums.length, 0);
        return output;
    }

    public void backtrack(List<List<Integer>> output, List<Integer> list, int n, int index) {
        if (index == n) {
            output.add(new ArrayList<>(list));
            System.out.println(output.size());
            return;
        }
        for (int i = index; i < n; i++) {
            if (i != index && list.get(index).equals(list.get(i))) {
                continue;
            }
            Collections.swap(list, i, index);
            backtrack(output, list, n, index + 1);
            Collections.swap(list, i, index);
            while (i < n - 1 && list.get(i).equals(list.get(i + 1))) {
                i++;
            }
        }
    }
}

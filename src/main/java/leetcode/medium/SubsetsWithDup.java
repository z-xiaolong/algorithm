package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author long
 * @Date 2021/3/31 9:52
 * @Title
 * @Description //TODO
 **/

public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, output, list, 0, false);
        return output;
    }

    public void dfs(int[] nums, List<List<Integer>> output, List<Integer> list, int i, boolean choice) {
        int n = nums.length;
        if (i == n) {
            output.add(new ArrayList<>(list));
            return;
        }
        dfs(nums, output, list, i + 1, false);
        if (i > 0 && nums[i] == nums[i - 1] && !choice) {
            return;
        }
        list.add(nums[i]);
        dfs(nums, output, list, i + 1, true);
        list.remove(list.size() - 1);
    }
}

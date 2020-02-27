package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/2/11 16:21
 * @Title
 * @Description 给定一个数组 candidates 和一个目标数target，
 * 找出candidates中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 **/

public class CombinationSum2 {
    public  List<List<Integer>> output = new LinkedList<>();
    public  Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(target, candidates, 0);
        return output;
    }

    public void backtrack(int target, int[] candidates, int index) {
        if (target == 0) {
            output.add(new LinkedList<>(stack));
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            stack.push(candidates[i]);
            backtrack(target - candidates[i], candidates, i + 1);
            stack.pop();
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}

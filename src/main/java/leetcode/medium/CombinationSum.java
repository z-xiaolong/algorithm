package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/2/11 11:39
 * @Title
 * @Description //TODO
 **/

/*回溯算法模板
result = []
function backtrack(路径, 选择列表){
    if 满足结束条件:
        result.add(路径)
        return
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
}
 */
public class CombinationSum {

    public static void main(String[] args) {
        int target = 7;
        int[] candidates = new int[]{4, 2, 1, 7};
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> output = combinationSum.combinationSum(candidates, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        backtrack(stack, output, target, candidates, 0);
        return output;
    }

    public void backtrack(Stack<Integer> stack, List<List<Integer>> output, int target, int[] candidates, int index) {
        if (target == 0) {
            output.add(new LinkedList<>(stack));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                stack.push(candidates[i]);
                backtrack(stack, output, target - candidates[i], candidates, i);
                stack.pop();
            }
        }
    }

    public void recursion() {

    }
}

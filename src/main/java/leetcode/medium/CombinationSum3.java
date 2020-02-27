package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/2/11 20:48
 * @Title
 * @Description 找出所有相加之和为 n 的k个数的组合。组合中只允许含有 1 -9 的正整数，
 * 并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 **/

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> output = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        backtrack(1, k, n, output, stack);
        return output;
    }

    public void backtrack(int index, int k, int n, List<List<Integer>> output, Stack<Integer> stack) {
        if (n == 0 && stack.size() == k) {
            output.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i <= 9 && n >= i; i++) {
            stack.push(i);
            backtrack(i + 1, k, n - i, output, stack);
            stack.pop();
        }
    }
}

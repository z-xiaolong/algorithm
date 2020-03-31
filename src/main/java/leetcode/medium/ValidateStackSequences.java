package leetcode.medium;


import java.util.Stack;

/**
 * @Author long
 * @Date 2020/3/24 11:25
 * @Title 946. 验证栈序列
 * @Description //TODO
 **/

public class ValidateStackSequences {


    //官方解
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == N;
    }


    //执行用时 :2 ms, 在所有 Java 提交中击败了93.85%的用户
    public boolean validateStackSequencesI(int[] pushed, int[] popped) {
        int length = popped.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < length; ) {
            if (j < length && pushed[j] == popped[i]) {
                i++;
                j++;
            } else if (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            } else if (j < length) {
                stack.add(pushed[j]);
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}

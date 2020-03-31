package leetcode.swordOffer.medium;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/3/23 17:40
 * @Title 面试题31. 栈的压入、弹出序列
 * @Description //TODO
 **/

public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        validateStackSequences(pushed, popped);
    }


    //栈模拟：执行用时 :3 ms, 在所有 Java 提交中击败了85.49%的用户
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = popped.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; j < length; ) {
            if (i < length && popped[j] == pushed[i]) {
                i++;
                j++;
            } else if (!stack.empty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else if (i < length) {
                stack.push(pushed[i]);
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}

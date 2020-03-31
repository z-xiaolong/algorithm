package leetcode.swordOffer.easy;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/3/7 10:24
 * @Title 面试题30. 包含min函数的栈
 * @Description //TODO
 **/

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int num = stack.pop();
        if (num == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

package leetcode.easy;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author long
 * @Date 20:05 2019/11/9
 * @Title 155. 最小栈
 * @Description 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 **/

public class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> minimumStack;
    private int minimum = Integer.MAX_VALUE;

    public MinStack() {
        stack = new LinkedList<>();
        minimumStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (x <= minimum) {
            minimum = x;
            minimumStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        if (top == minimum) {
            minimumStack.pop();
            if (!minimumStack.isEmpty()) {
                minimum = minimumStack.getFirst();
            } else {
                minimum = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minimum;
    }
}

class MinStack_two {
    private Stack<Integer> stack;
    private Stack<Integer> minimumStack;
    private int minimum = Integer.MAX_VALUE;

    public MinStack_two() {
        stack = new Stack<>();
        minimumStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (x <= minimum) {
            minimum = x;
            minimumStack.push(x);
        }
    }

    public void pop() {
        int top = stack.pop();
        if (top == minimum) {
            minimumStack.pop();
            if(!minimumStack.empty()){
                minimum = minimumStack.peek();
            } else {
                minimum = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimum;
    }
}

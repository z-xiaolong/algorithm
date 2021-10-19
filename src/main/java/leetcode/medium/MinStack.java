package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author long
 * @Date 2021/9/9 15:40
 * @Title 最小栈
 * @Description //设计一个栈，除了常规栈支持的pop与push函数以外，
 * 还支持min函数，该函数返回栈元素中的最小值。 数据范围[-100000，100000]
 * 执行push、pop和min操作的时间复杂度必须为O(1), 空间复杂度也为O(1),即不使用额外的内存空间
 * 思路：栈顶存放与最小值的差值，必须要在该数据范围之内，不限数据范围不能做到空间复杂度为O(1)
 **/

public class MinStack {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.pop();
    }

    private final Deque<Long> stack;
    private long min;

    public MinStack() {
        this.stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            long sub = x - min;
            stack.push(sub);
            if (sub < 0) {
                min = x;
            }
        }
    }

    public void pop() {
        long top = stack.pop();
        if (top < 0) {
            min = min - top;
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        if (stack.peek() <= 0) return (int) min;
        return (int) (stack.peek() + min);
    }

    public int getMin() {
        return (int) min;
    }
}

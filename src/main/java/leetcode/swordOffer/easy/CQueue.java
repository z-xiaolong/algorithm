package leetcode.swordOffer.easy;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/3/5 21:33
 * @Title 面试题09. 用两个栈实现队列
 * @Description 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 **/

public class CQueue {

    private Stack<Integer> stackAdd = new Stack<>();
    private Stack<Integer> stackDelete = new Stack<>();
    private int elementCount = 0;

    public CQueue() {

    }

    public void appendTail(int value) {
        stackAdd.push(value);
        elementCount++;
    }

    public int deleteHead() {
        if (elementCount <= 0) {
            return -1;
        }
        if (stackDelete.isEmpty()) {
            while (!stackAdd.isEmpty()) {
                stackDelete.push(stackAdd.pop());
            }
        }
        elementCount--;
        return stackDelete.pop();
    }
}

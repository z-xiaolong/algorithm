package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/3/1 13:28
 * @Title 225. 用队列实现栈
 * @Description //TODO
 **/

public class MyStack {

    private Node bottom;
    private Node top;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        bottom = new Node(Integer.MAX_VALUE);
        top = bottom;
        size = 0;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        Node node = new Node(x);
        top.next = node;
        node.pre = top;
        top = node;
        size++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int value = top.value;
        top = top.pre;
        top.next = null;
        size--;
        return value;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top.value;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return size <= 0;
    }

    class Node {
        public int value;
        public Node next;
        public Node pre;

        public Node(Integer value) {
            this.value = value;
        }
    }
}

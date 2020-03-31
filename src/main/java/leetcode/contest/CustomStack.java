package leetcode.contest;

/**
 * @Author long
 * @Date 2020/3/15 11:09
 * @Title
 * @Description //TODO
 **/

//5357. 设计一个支持增量操作的栈
public class CustomStack {

    private int maxSize;
    private Node bottom;
    private int size;
    private Node top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.bottom = new Node(Integer.MAX_VALUE);
        top = bottom;
        size = 0;
    }

    public void push(int x) {
        if (size >= maxSize) {
            return;
        }
        Node node = new Node(x);
        top.next = node;
        node.prv = top;
        top = node;
        size++;
    }

    public int pop() {
        if (top == bottom) {
            return -1;
        }
        Node node = top;
        top = top.prv;
        top.next = null;
        node.prv = null;
        size--;
        return node.val;
    }

    public void increment(int k, int val) {
        Node head = bottom.next;
        while (k > 0 && head != null) {
            head.val += val;
            head = head.next;
            k--;
        }
    }

    class Node {
        private Node next;
        private Node prv;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }
}

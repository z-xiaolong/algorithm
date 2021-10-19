package leetcode.medium;

/**
 * @Author long
 * @Date 2021/10/7 10:21
 * @Title
 * @Description //TODO
 **/

public class MyCircularQueue {

    private final int[] container;
    private final int capacity; //容量
    private int head; //头指针
    private int tail; //尾指针

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.container = new int[k];
        this.head = 0;
        this.tail = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        container[tail % capacity] = value;
        tail++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head++;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return container[head % capacity];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return container[(tail - 1) % capacity];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail - head == capacity;
    }
}

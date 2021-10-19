package leetcode.medium;

/**
 * @Author long
 * @Date 2021/9/23 22:22
 * @Title
 * @Description //TODO
 **/

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(0);
        list.addAtIndex(1, 4);
        list.addAtTail(8);
        list.addAtHead(5);
        list.addAtIndex(4, 3);
        list.addAtTail(0);
        list.addAtTail(5);
        list.addAtIndex(6, 3);
        list.deleteAtIndex(7);
        list.deleteAtIndex(5);
        list.addAtTail(4);
    }

    private final Node head;
    private Node tail;
    private int size;


    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new Node(-1);
        tail = head;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size || index < 0) return -1;
        Node node = head;
        while (index >= 0) {
            node = node.next;
            index--;
        }
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head.next == null) {
            head.next = node;
            tail = node;
        } else {
            Node next = head.next;
            head.next = node;
            node.next = next;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail == head) {
            head.next = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index < size) {
            Node node = new Node(val);
            Node next = head;
            while (index > 0) {
                next = next.next;
                index--;
            }
            Node tmp = next.next;
            next.next = node;
            node.next = tmp;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node next = head;
        while (index > 0) {
            next = next.next;
            index--;
        }
        next.next = next.next.next;
        if (next.next == null) tail = next;
        size--;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}

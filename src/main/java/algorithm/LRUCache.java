package algorithm;

import java.util.HashMap;

/**
 * @Author long
 * @Date 2021/10/8 21:01
 * @Title
 * @Description //TODO
 **/

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

    private int capacity;
    private int size;
    private HashMap<Integer, Node> map = new HashMap<>();
    private final Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = this.head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.value = value;
            add(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
            size++;
            if (size > capacity) {
                map.remove(head.next.key);
                remove(head.next);
                size--;
            }
        }
    }

    private void remove(Node node) {
        if (node == null) return;
        if (node == tail) {
            tail = node.prev;
            tail.next = null;
            node.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
    }

    private void add(Node node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
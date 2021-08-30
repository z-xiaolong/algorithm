package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/4/5 16:38
 * @Title 146. LRU缓存机制
 * @Description //TODO
 **/

public class LRUCache {


    private int capacity;
    private Map<Integer, Node> cacheMap;
    private Node head;
    private Node tail;

    //执行用时 :25 ms, 在所有 Java 提交中击败了52.81%的用户
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.cacheMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            addNode(node);
        }
    }

    private void addNode(Node node) {
        if (capacity == 0) {
            return;
        }
        if (cacheMap.size() == capacity && !cacheMap.containsKey(node.key)) {
            Node deadNode = removeTail();
            cacheMap.remove(deadNode.key);
        }
        addToHead(node);
        cacheMap.put(node.key, node);
    }

    private void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }

    private Node removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        return node;
    }

    private Node removeTail() {
        Node node = tail.prev;
        return removeNode(node);
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

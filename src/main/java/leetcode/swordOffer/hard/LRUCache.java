package leetcode.swordOffer.hard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/4/5 17:28
 * @Title 146. LRU缓存机制
 * @Description //TODO
 **/

//双向链表
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }

    private int capacity;
    int size;
    private Node head;
    private Node tail;
    private Map<Integer, Node> cacheMap = new HashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) return -1;
        deleteNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cacheMap.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (size >= capacity) {
                removeTailNode();
            }
            cacheMap.put(key, node);
            addNode(node);
        } else {
            node.value = value;
            deleteNode(node);
            addNode(node);
        }
    }

    public void removeTailNode() {
        if (tail.prev == head) return;
        Node temp = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        cacheMap.remove(temp.key);
        size--;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--;
    }

    public void addNode(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    class LRUCacheI extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCacheI(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
            return size() > capacity;
        }
        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }
    }
}

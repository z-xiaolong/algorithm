package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/3/18 20:14
 * @Title
 * @Description //TODO
 **/

class LRUCache {


    int capacity;
    int size;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        ListNode node = cache.get(key);
        remove(node);
        addFirst(node);
        return node.value;
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    public void put(int key, int value) {
        ListNode node = new ListNode(key, value);
        if (cache.containsKey(key)) {
            ListNode oldNode = cache.get(key);
            remove(oldNode);
        } else {
            size++;
        }
        addFirst(node);
        cache.put(key, node);
        if (size > capacity) {
            ListNode last = removeLast();
            cache.remove(last.key);
            size--;
        }

    }

    private ListNode removeLast() {
        ListNode last = tail.prev;
        remove(last);
        return last;
    }

    private void addFirst(ListNode node) {
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public ListNode() {
        }
    }

}

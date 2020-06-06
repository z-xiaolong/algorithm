package leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/4/5 9:53
 * @Title 460. LFU缓存
 * @Description 这个缓存算法使用一个计数器来记录条目被访问的频率。
 * 通过使用LFU缓存算法，最低访问数的条目首先被移除。
 **/

public class LFUCache {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        cache.put(2, 2);
        cache.put(1, 1);
        cache.get(2);
        cache.get(1);
        cache.get(2);  // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.put(4, 4);
        cache.get(3);       // 返回 -1 (未找到key 2)
        cache.get(2);       // 返回 3
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(4);       // 返回 4
    }

    private int capacity;
    private int minFreq;
    private Map<Integer, Node> cacheMap;
    private Map<Integer, LinkedHashSet<Node>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>(capacity);
        this.freqMap = new HashMap<>();
        this.minFreq = 1;
    }

    public int get(int key) {
        Node node = cacheMap.getOrDefault(key, null);
        if (node == null) return -1;
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = cacheMap.getOrDefault(key, null);
        if (node == null) {
            node = new Node(key, value);
            if (cacheMap.size() == capacity) removeNode();
            addNode(node);
        } else {
            node.value = value;
            updateFreq(node);
        }
    }

    private Node removeNode() {
        LinkedHashSet<Node> nodes = freqMap.get(minFreq);
        Node deadNode = nodes.iterator().next();
        nodes.remove(deadNode);
        cacheMap.remove(deadNode.key);
        return deadNode;
    }

    private void addNode(Node node) {
        cacheMap.put(node.key, node);
        LinkedHashSet<Node> nodes = freqMap.getOrDefault(node.fre, new LinkedHashSet<>());
        minFreq = node.fre;
        nodes.add(node);
        freqMap.put(node.fre, nodes);
    }

    private void updateFreq(Node node) {
        LinkedHashSet<Node> nodes = freqMap.get(node.fre);
        nodes.remove(node);
        if (node.fre == minFreq && nodes.size() == 0) {
            minFreq++;
        }
        node.fre++;
        nodes = freqMap.getOrDefault(node.fre, new LinkedHashSet<>());
        nodes.add(node);
        freqMap.put(node.fre, nodes);
    }

    class Node {
        int key;
        int value;
        int fre = 1;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

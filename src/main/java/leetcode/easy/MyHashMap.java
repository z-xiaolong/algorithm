package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/3/14 10:14
 * @Title
 * @Description //TODO
 **/

public class MyHashMap {

    private final int size = 769;
    private List[] map;

    public MyHashMap() {
        map = new List[size];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = hash(key);
        if (map[hash] == null) {
            map[hash] = new ArrayList<Node>();
        }
        List<Node> list = map[hash];
        for (Node node : list) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        list.add(new Node(key, value));
    }

    private int hash(int key) {
        return key % size;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = hash(key);
        if (map[hash] == null) {
            map[hash] = new ArrayList<Node>();
            return -1;
        }
        List<Node> list = map[hash];
        for (Node node : list) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = hash(key);
        if (map[hash] == null) {
            map[hash] = new ArrayList<Node>();
            return;
        }
        List<Node> list = map[hash];
        for (Node node : list) {
            if (node.key == key) {
                list.remove(node);
                return;
            }
        }
    }

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

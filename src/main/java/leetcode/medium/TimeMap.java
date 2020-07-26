package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/7/22 10:31
 * @Title
 * @Description //TODO
 **/

public class TimeMap {

    private Map<String, NodeList> hashMap = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new NodeList());
        }
        NodeList nodeList = hashMap.get(key);
        nodeList.add(value, timestamp);
    }

    public String get(String key, int timestamp) {
        if (!hashMap.containsKey(key)) {
            return "";
        }
        NodeList nodeList = hashMap.get(key);
        return nodeList.getValue(timestamp);
    }

    class NodeList {

        Node[] nodes = new Node[32];
        int size = 0;

        public void add(String value, int timestamp) {
            if (size == nodes.length) {
                grow();
            }
            nodes[size] = new Node(value, timestamp);
            size++;
        }

        public void grow() {
            int oldSize = size;
            int newSize = oldSize + oldSize * 2;
            Node[] newNodes = new Node[newSize];
            if (oldSize >= 0)
                System.arraycopy(nodes, 0, newNodes, 0, oldSize);
            nodes = newNodes;
        }

        public String getValue(int timestamp) {
            int left = 0;
            int right = size - 1;
            if (nodes[left].timestamp > timestamp) return "";
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (nodes[mid].timestamp < timestamp) {
                    left = mid + 1;
                } else if (nodes[mid].timestamp > timestamp) {
                    right = mid - 1;
                } else {
                    return nodes[mid].value;
                }
            }
            if (nodes[left].timestamp > timestamp)
                return nodes[left - 1].value;
            return nodes[left].value;
        }

        class Node {
            String value;
            int timestamp;

            public Node(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }
    }


}

package leetcode.medium;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/12 9:18
 * @Title
 * @Description:
 */
public class CloneGraph {


    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        visited.put(node, new Node(node.val));
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node neighbor : temp.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                visited.get(temp).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

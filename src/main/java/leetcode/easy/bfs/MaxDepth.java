package leetcode.easy.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/3/9 17:44
 * @Title 559. N叉树的最大深度
 * @Description 给定一个 N 叉树，找到其最大深度。
 **/

public class MaxDepth {

    //DFS: 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    public int dfs(Node node) {
        if (node.children == null || node.children.isEmpty()) {
            return 1;
        }
        List<Node> children = node.children;
        int depth = 0;
        for (Node n : children) {
            depth = Math.max(depth, dfs(n));
        }
        return depth + 1;
    }


    //BFS: 执行用时 :3 ms, 在所有 Java 提交中击败了21.85%的用户
    public int maxDepthI(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size > 0) {
                Node node = queue.poll();
                List<Node> children = node.children;
                if (children != null && !children.isEmpty()) {
                    queue.addAll(children);
                }
                size--;
            }
        }
        return depth;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

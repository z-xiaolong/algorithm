package leetcode.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/7/19 8:38
 * @Title
 * @Description //TODO
 **/

public class Contest198 {


    public int numWaterBottles(int numBottles, int numExchange) {
        int max = numBottles;
        while (numBottles / numExchange > 0) {
            int newBottles = numBottles / numExchange;
            max += newBottles;
            numBottles = newBottles + numBottles % numExchange;
        }
        return max;
    }


    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] res = new int[n];
        Node[] nodes = new Node[n];
        for (int[] edge : edges) {
            if (nodes[edge[0]] == null) {
                nodes[edge[0]] = new Node();
                nodes[edge[0]].val = labels.charAt(edge[0]);
            }
            nodes[edge[0]].child.add(edge[1]);
        }
        Map<Character, Integer> hashMap = new HashMap<>();
        dfs(nodes, res, 0, hashMap, labels);
        return res;
    }

    public void dfs(Node[] nodes, int[] res, int index, Map<Character, Integer> map, String labels) {
        Node node = nodes[index];
        char c = labels.charAt(index);

        if (node == null) {
            res[index] = 1;
            map.put(c, map.getOrDefault(c, 0) + 1);
            return;
        }
        Set<Integer> set = node.child;
        for (int i : set) {
            dfs(nodes, res, i, map, labels);
            node.cnt = map.get(c);
        }
        map.put(c, map.getOrDefault(c, 0) + 1);
        res[index] = node.cnt;
    }

    class Node {
        Set<Integer> child = new HashSet<>();
        char val;
        int cnt = 0;
    }


    public static void main(String[] args) {
        Contest198 contest = new Contest198();
    }
}

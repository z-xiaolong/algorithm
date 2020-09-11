package leetcode.medium;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: long
 * @date: 2020/7/27 10:01
 * @Title: 5474. 好叶子节点对的数量
 * @description:
 */
public class CountPairs {

    int res = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    public List<Integer> dfs(TreeNode node, int distance) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;
        if (node.left == null && node.right == null) {
            list.add(1);
            return list;
        }
        List<Integer> left = dfs(node.left, distance);
        List<Integer> right = dfs(node.right, distance);
        for (int i : left) {
            for (int j : right) {
                if (i + j <= distance) {
                    res++;
                }
            }
        }
        for (int i : left) {
            if (++i < distance)
                list.add(i);
        }
        for (int j : right) {
            if (++j < distance)
                list.add(j);
        }
        return list;
    }
}

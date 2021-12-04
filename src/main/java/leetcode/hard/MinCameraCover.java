package leetcode.hard;

import leetcode.entity.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/10/19 21:15
 * @Title
 * @Description //TODO
 **/

public class MinCameraCover {

    private final Map<TreeNode, int[]> map = new HashMap<>();

    public int minCameraCover(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        int cover = dfs(root, 0);
        int notCover = dfs(root, -1);
        return Math.min(cover, notCover);
    }

    public int dfs(TreeNode node, int depth) {
        if (node == null) return 0;
        int[] state;
        if (map.containsKey(node)) {
            state = map.get(node);
        } else {
            state = new int[3];
            Arrays.fill(state, -1);
        }
        if (state[depth] != -1) return state[depth];
        int min = 0;
        if (depth == 2) {
            int cover = dfs(node.left, 2) + dfs(node.right, 2) + 1;
            int notCover = dfs(node.left, 1) + dfs(node.right, 1);
            min = Math.min(cover, notCover);
        } else if (depth == 0) {
            min = dfs(node.left, 2) + dfs(node.right, 2) + 1;
        } else if (depth == 1) {
            if (node.left == null && node.right == null) return 1;
            int cover = dfs(node.left, 2) + dfs(node.right, 2) + 1;
            int notCover = dfs(node.left, 0) + dfs(node.right, 0);
            if (node.left != null)
                notCover = Math.min(notCover, dfs(node.left, 0) + dfs(node.right, 1));
            if (node.right != null)
                notCover = Math.min(notCover, dfs(node.left, 1) + dfs(node.right, 0));
            min = Math.min(cover, notCover);
        }
        state[depth] = min;
        map.put(node, state);
        return min;
    }
}

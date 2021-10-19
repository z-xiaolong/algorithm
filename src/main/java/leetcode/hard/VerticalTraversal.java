package leetcode.hard;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/9/28 20:47
 * @Title
 * @Description //TODO
 **/

public class VerticalTraversal {


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        dfs(list, root, 0, 0);
        list.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else if (a[1] != b[1]) return a[1] - b[1];
            else return a[2] - b[2];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        int size = 0;
        for (int[] tuple : list) {
            int x = tuple[0];
            int v = tuple[2];
            if (x != prev) {
                prev = x;
                ans.add(new ArrayList<>());
                size++;
            }
            ans.get(size - 1).add(v);
        }
        return ans;
    }

    public void dfs(List<int[]> list, TreeNode node, int row, int col) {
        if (node == null) return;
        list.add(new int[]{row, col, node.val});
        dfs(list, node.left, row - 1, col + 1);
        dfs(list, node.right, row + 1, col + 1);
    }
}

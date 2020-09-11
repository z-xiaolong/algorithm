package leetcode.medium;

import leetcode.entity.TreeNode;

/**
 * @Author: long
 * @Date: 2020/8/5 9:15
 * @Title 337. 打家劫舍 III
 * @Description:
 */
public class Rob {

    public int rob(TreeNode root) {
        int[] select = dfs(root);
        return Math.max(select[0], select[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] select = new int[2];
        select[0] = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);
        select[1] = node.val + left[0] + right[0];
        return select;
    }


}

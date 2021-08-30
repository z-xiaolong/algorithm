package leetcode.medium.dp;

import leetcode.entity.TreeNode;

import java.util.*;

/**
 * @Author long
 * @Date 2021/4/23 10:24
 * @Title
 * @Description //TODO
 **/

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxVal = 0;
        int maxSize = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxSize--;
                maxVal = nums[i];
            }
        }
        return res;
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(0);
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root.left != null) {
            stack.push(root);
            root = root.left;
        }
        head.right = root;
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            if (root.right != null) {
                root = root.left;
            }
        }
        return head.right;
    }
}

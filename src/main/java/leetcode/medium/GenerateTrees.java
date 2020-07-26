package leetcode.medium;

import exam.Main;
import leetcode.entity.ListNode;

import java.util.*;

/**
 * @Author long
 * @Date 2020/7/21 9:20
 * @Title
 * @Description //TODO
 **/

public class GenerateTrees {

    public static void main(String[] args) {
        Map<int[], String> map = new HashMap<>();
        map.put(new int[]{1, 1}, "aaaa");
        System.out.println(map.get(new int[]{1, 1}));
    }


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = new ArrayList<>();
            dp[i][i].add(new TreeNode(i));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j + i <= n; j++) {
                if (dp[j][j + i] == null)
                    dp[j][j + i] = new ArrayList<>();
                for (int k = j; k <= j + i; k++) {
                    if (k == j) {
                        List<TreeNode> list = dp[k + 1][j + i];
                        for (TreeNode treeNode : list) {
                            TreeNode node = new TreeNode(k);
                            node.right = treeNode;
                            dp[j][j + i].add(node);
                        }
                    } else if (k == j + i) {
                        List<TreeNode> list = dp[j][k - 1];
                        for (TreeNode treeNode : list) {
                            TreeNode node = new TreeNode(k);
                            node.left = treeNode;
                            dp[j][j + i].add(node);
                        }
                    } else {
                        List<TreeNode> left = dp[j][k - 1];
                        List<TreeNode> right = dp[k + 1][j + i];
                        for (TreeNode leftNode : left) {
                            for (TreeNode rightNode : right) {
                                TreeNode node = new TreeNode(k, leftNode, rightNode);
                                dp[j][j + i].add(node);
                            }
                        }
                    }
                }
            }
        }
        return dp[1][n];
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

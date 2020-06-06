package leetcode.contest;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/5/24 10:27
 * @Title
 * @Description //TODO
 **/

public class Contest190 {

    //5416. 检查单词是否为句中其他单词的前缀
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.contains(searchWord)) {
                int j = 0;
                while (j < searchWord.length()) {
                    if (word.charAt(j) == searchWord.charAt(j)) {
                        j++;
                    } else {
                        break;
                    }
                }
                if (j == searchWord.length())
                    return i + 1;
            }
        }
        return -1;
    }

    //5417. 定长子串中元音的最大数目
    public int maxVowels(String s, int k) {
        int max = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            if (right - left + 1 <= k) {
                if (check(s.charAt(right))) count++;
                right++;
            } else if (right - left + 1 > k) {
                if (check(s.charAt(right))) count++;
                if (check(s.charAt(left))) count--;
                left++;
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    //5418. 二叉树中的伪回文路径
    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) return 0;
        int[] flag = new int[10];
        backtrack(flag, root);
        return count;
    }

    private int count = 0;

    public void backtrack(int[] flag, TreeNode node) {
        if (node.left == null && node.right == null) {
            flag[node.val]++;
            if (check(flag)) count++;
            flag[node.val]--;
            return;
        }
        flag[node.val]++;
        if (node.left != null) {
            backtrack(flag, node.left);
        }
        if (node.right != null) {
            backtrack(flag, node.right);
        }
        flag[node.val]--;
    }

    public boolean check(int[] flag) {
        int count = 0;
        for (int i : flag) {
            if (i % 2 == 1) count++;
        }
        return count <= 1;
    }


    //5419. 两个子序列的最大点积
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 5][m + 5];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                max = Math.max(max, dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
            }
        }
        return max;
    }


}

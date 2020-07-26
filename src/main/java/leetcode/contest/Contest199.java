package leetcode.contest;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/7/26 10:22
 * @Title
 * @Description //TODO
 **/

public class Contest199 {

    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }


    public int minFlips(String target) {
        int count = 0;
        int n = target.length() - 1;
        char prev = '0';
        for (int i = 0; i < n; i++) {
            if (target.charAt(i) != prev) {
                count++;
                prev = target.charAt(i);
            }
        }
        return count;
    }

    public int countPairs(TreeNode root, int distance) {
        return 0;
    }


    public static void main(String[] args) {
        Contest199 contest = new Contest199();
    }
}

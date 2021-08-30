package leetcode.easy;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: long
 * @Date: 2020/10/12 11:02
 * @Title
 * @Description:
 */
public class GetMinimumDifference {

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        GetMinimumDifference getMinimumDifference = new GetMinimumDifference();
        getMinimumDifference.commonChars(A);
    }

    public List<String> commonChars(String[] A) {
        int[] map = new int[26];
        for (String s : A) {
            add(s, map);
        }
        List<String> list = new ArrayList<>();
        String chars = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < map.length; i++) {
            if (map[i] == A.length) {
                list.add(chars.substring(i, i + 1));
            }
        }
        return list;
    }


    public void add(String word, int[] map) {
        boolean[] flag = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            flag[c - 'a'] = true;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                map[i]++;
            }
        }
    }


    public static int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root, Integer.MIN_VALUE);
        return res;
    }


    public int inorder(TreeNode node, int pre) {
        if (node.left != null) {
            pre = inorder(node.left, pre);
        }
        res = Math.min(Math.abs(node.val - pre), res);
        pre = node.val;
        if (node.right != null) {
            pre = inorder(node.right, node.val);
        }
        return pre;
    }
}

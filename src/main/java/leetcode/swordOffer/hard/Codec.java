package leetcode.swordOffer.hard;

import leetcode.entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @Author long
 * @Date 2020/4/6 11:51
 * @Title 面试题37. 序列化二叉树
 * @Description //TODO
 **/

public class Codec {


    //DFS
    // 执行用时 :7 ms, 在所有 Java 提交中击败了97.49%的用户
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        dfs(builder, root);
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    public void dfs(StringBuilder builder, TreeNode node) {
        if (node == null) {
            builder.append('n').append(',');
            return;
        }
        builder.append(node.val).append(',');
        dfs(builder, node.left);
        dfs(builder, node.right);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        if (datas[0].equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        buildTree(root, datas, 0);
        return root;
    }

    public int buildTree(TreeNode node, String[] data, int index) {
        if (node == null) return index + 1;
        int left = index + 1;
        if (left < data.length && !data[left].equals("n")) {
            node.left = new TreeNode(Integer.parseInt(data[left]));
        }
        int right = buildTree(node.left, data, left);
        if (right < data.length && !data[right].equals("n")) {
            node.right = new TreeNode(Integer.parseInt(data[right]));
        }
        return buildTree(node.right, data, right);
    }

}

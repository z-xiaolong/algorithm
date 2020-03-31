package leetcode.swordOffer.medium;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/3/25 11:15
 * @Title 面试题34. 二叉树中和为某一值的路径
 * @Description //TODO
 **/

public class PathSum {

    //递归+回溯： 执行用时 :2 ms, 在所有 Java 提交中击败了67.27%的用户
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        List<Integer> list = new LinkedList<>();
        recur(output, list, root, sum);
        return output;
    }

    public void recur(List<List<Integer>> output, List<Integer> list, TreeNode node, int sum) {
        if (sum == node.val && node.left == null && node.right == null) {
            list.add(node.val);
            output.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(node.val);
        if (node.left != null) {
            recur(output, list, node.left, sum - node.val);
        }
        if (node.right != null) {
            recur(output, list, node.right, sum - node.val);
        }
        list.remove(list.size() - 1);
    }
}

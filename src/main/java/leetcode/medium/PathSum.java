package leetcode.medium;

import leetcode.entity.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/9/28 10:47
 * @Title
 * @Description //TODO
 **/

public class PathSum {

    public int pathSum(TreeNode root, int sum) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

        }
        return 0;
    }
}

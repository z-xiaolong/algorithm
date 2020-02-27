package leetcode.medium;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/2/9 15:03
 * @Title
 * @Description //TODO
 **/

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        recursion(root, list);
        return list;
    }

    public void recursion(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            recursion(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            recursion(root.right, list);
        }
    }
}

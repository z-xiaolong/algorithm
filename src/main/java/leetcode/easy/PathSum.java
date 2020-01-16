package leetcode.easy;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 21:58 2019/10/31
 * @Title 437. 路径总和 III
 * @Description 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 **/

public class PathSum {

    /*112. 路径总和
    给定一个二叉树和一个目标和，判断该树中是否存在 '节点到叶子节点' 的路径，这条路径上所有节点值相加等于目标和。
    说明: 叶子节点是指没有子节点的节点。*/
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.right == null && root.left == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    /*113. 路径总和 II
    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
    说明: 叶子节点是指没有子节点的节点。*/

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        if (root == null) return lists;
        subPath(root, new ArrayList<>(), sum);
        return lists;
    }

    public void subPath(TreeNode node, List<Integer> list, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        List<Integer> subList = new ArrayList<>(list);
        subList.add(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            lists.add(subList);
            return;
        }
        subPath(node.left, subList, sum);
        subPath(node.right, subList, sum);
    }


    //双重递归
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return sum(root, sum) + pathSum(root.right, sum) + pathSum(root.left, sum);
    }

    public int sum(TreeNode root, int sum) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        if (sum == root.val) {
            count++;
        }
        count += sum(root.left, sum - root.val);
        count += sum(root.right, sum - root.val);
        return count;
    }
}

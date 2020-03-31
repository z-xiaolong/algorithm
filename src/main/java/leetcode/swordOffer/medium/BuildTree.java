package leetcode.swordOffer.medium;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/3/10 13:28
 * @Title 面试题07. 重建二叉树
 * @Description 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 **/

public class BuildTree {
    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] pre = new int[]{1, 2, 3};
        int[] in = new int[]{2, 3, 1};
        buildTree.buildTree(pre, in);
    }

    //优化DFS：
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return depth(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode depth(int[] preOrder, int preIndex, int[] inOrder, int left, int right) {
        if (left > right) {
            return null;
        }
        int value = preOrder[preIndex];
        int index = left;
        for (int i = left; i <= right; i++) {
            if (inOrder[i] == value) {
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(value);
        node.left = depth(preOrder, preIndex + 1, inOrder, left, index - 1);
        node.right = depth(preOrder, preIndex + index - left + 1, inOrder, index + 1, right);
        return node;
    }

    //DFS递归： 执行用时 :7 ms, 在所有 Java 提交中击败了43.89%的用户
    public TreeNode buildTreeI(int[] preorder, int[] inorder) {
        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildSubTree(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int value = preOrder[preLeft];
        if (preLeft == preRight) {
            return new TreeNode(value);
        }
        int index = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inOrder[i] == value) {
                index = i;
                break;
            }
        }
        int length = index - inLeft;
        TreeNode node = new TreeNode(value);
        node.left = buildSubTree(preOrder, preLeft + 1, preLeft + length, inOrder, inLeft, index - 1);
        node.right = buildSubTree(preOrder, preLeft + length + 1, preRight, inOrder, index + 1, inRight);
        return node;
    }
}

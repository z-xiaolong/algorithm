package leetcode.medium;

import leetcode.entity.TreeNode;

/**
 * @Author: long
 * @Date: 2020/9/25 9:55
 * @Title
 * @Description:
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(inorder, postorder);
        System.out.println(treeNode);
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return build(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    public TreeNode build(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int val = postorder[postRight];
        TreeNode node = new TreeNode(val);
        int mid = inLeft;
        while (inorder[mid] != val) {
            mid++;
        }
        node.left = build(inorder, inLeft, mid - 1, postorder, postLeft, mid);
        node.right = build(inorder, mid + 1, inRight, postorder, mid + 1, postRight - 1);
        return node;
    }
}

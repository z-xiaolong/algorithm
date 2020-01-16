package leetcode.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 20:54 2019/10/29
 * @Title 538. 把二叉搜索树转换为累加树
 * @Description 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树。
 **/

public class ConvertBST_KEY {

    public TreeNode convertbst(TreeNode root) {
        if (root != null) {
            dfs(root, 0);
        }
        return root;
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        sum = dfs(node.right, sum);
        node.val += sum;
        sum = dfs(node.left, node.val);
        return sum;
    }


    int add = 0;
    public TreeNode convertBSTII(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBSTII(root.right);
        root.val = add + root.val;
        add = root.val;
        convertBSTII(root.left);
        return root;
    }
}

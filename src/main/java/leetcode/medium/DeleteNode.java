package leetcode.medium;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/4/8 11:59
 * @Title 450. 删除二叉搜索树中的节点
 * @Description //TODO
 **/

public class DeleteNode {


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right != null) {
                TreeNode successor = successor(root);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            } else if (root.left != null) {
                TreeNode predecessor = predecessor(root);
                root.val = predecessor.val;
                root.left = deleteNode(root.left, predecessor.val);
            } else {
                root = null;
            }
        }
        return root;
    }

    //节点右子树不为 null 时，得到节点的后继节点
    public TreeNode successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //节点左子树不为 null 时，得到节点的前驱节点
    public TreeNode predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public TreeNode deleteNodeI(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.right == null) return root.left;
            TreeNode left = findMin(root.right);
            left.left = root.left;
            return root.right;
        } else if (root.val > key) {
            delete(root, root.left, key);
        } else {
            delete(root, root.right, key);
        }
        return root;
    }

    public void delete(TreeNode parent, TreeNode node, int key) {
        if (node == null) return;
        if (node.val == key) {
            if (node.right == null) {
                if (parent.left == node) parent.left = node.left;
                else parent.right = node.left;
                return;
            }
            if (parent.left == node) parent.left = node.right;
            else parent.right = node.right;
            TreeNode left = findMin(node.right);
            left.left = node.left;
        } else if (node.val > key) {
            delete(node, node.left, key);
        } else {
            delete(node, node.right, key);
        }
    }

    public TreeNode findMin(TreeNode node) {
        if (node.left == null) return node;
        else return findMin(node.left);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                } else {
                    node = node.right;
                }
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                } else {
                    node = node.left;
                }
            }
        }
        return new TreeNode(val);
    }
}

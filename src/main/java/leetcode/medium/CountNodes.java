package leetcode.medium;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/11/24 11:10
 * @Title
 * @Description //TODO
 **/

public class CountNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        CountNodes countNodes = new CountNodes();
        countNodes.countNodes(root);


    }

    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int deep = depth(root);
        int low = 1 << deep;
        int high = (1 << (deep + 1)) - 1;
        while (low < high) {
            int mid =low + ((high - low + 1) >> 1);
            if (exist(root, deep, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int depth(TreeNode node) {
        int deep = 0;
        while (node.left != null) {
            node = node.left;
            deep++;
        }
        return deep;
    }

    public boolean exist(TreeNode root, int deep, int k){
        int bit = 1 << (deep - 1);
        while(root != null && bit > 0) {
            if((k & bit) == 0) {
                root = root.left;
            } else {
                root = root.right;
            }
            bit >>= 1;
        }
        return root != null;
    }
}

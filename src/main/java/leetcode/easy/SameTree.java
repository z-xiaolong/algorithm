package leetcode.easy;

/*给定两个二叉树，编写一个函数来检验它们是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。*/

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2019/10/3 21:38
 */
public class SameTree {


    //递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        boolean right = false;
        boolean left = false;
        if (p != null && q != null && p.val == q.val) {
            right = isSameTree(p.right, q.right);
            left = isSameTree(p.left, q.left);
        }
        return right && left;
    }

    //官方最优解, 需要先判断是否为null，再比较值
    public boolean isSameTreeP(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTreeP(p.right, q.right) &&
                isSameTreeP(p.left, q.left);
    }


}

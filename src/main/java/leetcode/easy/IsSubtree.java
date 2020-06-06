package leetcode.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/5/7 9:23
 * @Title 572. 另一个树的子树
 * @Description //TODO
 **/

public class IsSubtree {


    //字符串匹配KMP, 时间复杂度为 O（S+T）
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        inorder(s, s1);
        inorder(t, s2);
        String sStr = s1.toString();
        String tStr = s2.toString();
        return sStr.contains(tStr);
    }

    public void inorder(TreeNode node, StringBuilder builder) {
        builder.append('#').append(node.val);

        if (node.left == null) builder.append("#l");
        else inorder(node.left, builder);

        if (node.right == null) builder.append("#r");
        else inorder(node.right, builder);
    }

    //暴力法：时间复杂度：O(S * T)
    public boolean isSubtreeI(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        boolean res = false;
        if (s.val == t.val) {
            res = validate(s, t);
        }
        if (res) return true;
        res = isSubtree(s.left, t) || isSubtree(s.right, t);
        return res;
    }

    public boolean validate(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val == t.val) {
            return validate(s.left, t.left) && validate(s.right, t.right);
        }
        return false;
    }
}

package leetcode.easy;

import leetcode.entity.TreeNode;

/**
 * @Author long
 * @Date 2020/5/19 9:41
 * @Title 606. 根据二叉树创建字符串
 * @Description //TODO
 **/

public class Tree2str {

    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder builder = new StringBuilder();
        dfs(builder, t);
        return builder.toString();
    }

    public void dfs(StringBuilder sb, TreeNode t) {
        if (t == null) return;
        sb.append(t.val);
        if (t.left != null || t.right != null) {
            sb.append("(");
            dfs(sb, t.left);
            sb.append(")");
            if (t.right != null) {
                sb.append("(");
                dfs(sb, t.right);
                sb.append(")");
            }
        }
    }
}

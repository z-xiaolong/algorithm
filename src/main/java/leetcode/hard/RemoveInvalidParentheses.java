package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author long
 * @Date 2021/10/4 16:39
 * @Title
 * @Description //TODO
 **/

public class RemoveInvalidParentheses {

    private int len;
    private char[] charArray;
    private Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        this.len = s.length();
        this.charArray = s.toCharArray();
        int leftRemove = 0;
        int rightRemove = 0;
        for (char c : charArray) {
            if (c == '(') {
                leftRemove++;
            } else if (c == ')') {
                if (leftRemove == 0) {
                    rightRemove++;
                }
                if (leftRemove > 0) {
                    leftRemove--;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        dfs(0, 0, 0, builder, leftRemove, rightRemove);
        return new ArrayList<>(set);
    }

    public void dfs(int index, int left, int right, StringBuilder builder, int leftRemove, int rightRemove) {
        if (index == len) {
            if (leftRemove == 0 && rightRemove == 0) {
                set.add(builder.toString());
            }
            return;
        }
        char c = charArray[index];
        if (c == '(' && leftRemove > 0) {
            dfs(index + 1, left, right, builder, leftRemove - 1, rightRemove);
        }
        if (c == ')' && rightRemove > 0) {
            dfs(index + 1, left, right, builder, leftRemove, rightRemove - 1);
        }
        builder.append(c);
        if (c != '(' && c != ')') {
            dfs(index + 1, left, right, builder, leftRemove, rightRemove);
        } else if (c == '(') {
            dfs(index + 1, left + 1, right, builder, leftRemove, rightRemove);
        } else if (left > right) {
            dfs(index + 1, left, right + 1, builder, leftRemove, rightRemove);
        }
        builder.deleteCharAt(builder.length() - 1);
    }

}

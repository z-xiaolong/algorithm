package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/2/8 23:13
 * @Title
 * @Description 给出 n 代表生成括号的对数，请你写出一个函数，
 * 使其能够生成所有可能的并且有效的括号组合。
 **/

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        char[] chars = new char[n * 2];
        backtrack(0, result, chars, 0, 0);
        return result;
    }

    public void backtrack(int index, List<String> output, char[] chars, int left, int right) {
        if (left * 2 == chars.length) {
            for (int i = right + 1; i <= left; i++) {
                chars[index] = ')';
                index++;
            }
            output.add(new String(chars));
        } else if (left == right) {
            chars[index] = '(';
            backtrack(index + 1, output, chars, left + 1, right);
        } else if (left > right) {
            chars[index] = '(';
            backtrack(index + 1, output, chars, left + 1, right);
            chars[index] = ')';
            backtrack(index + 1, output, chars, left, right + 1);
        }
    }
}

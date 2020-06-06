package leetcode.swordOffer.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/4/9 9:44
 * @Title
 * @Description //TODO
 **/

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        char[] chars = new char[n * 2];
        backtrack(result, chars, 0, 0, 0);
        return result;
    }

    public void backtrack(List<String> output, char[] chars, int left, int right, int index) {
        if (left * 2 == chars.length) {
            while (index < chars.length && right < left) {
                chars[index++] = ')';
                right++;
            }
            output.add(new String(chars));
            return;
        }
        if (left == right) {
            chars[index] = '(';
            backtrack(output, chars, left + 1, right, index + 1);
        } else if (left > right) {
            chars[index] = '(';
            backtrack(output, chars, left + 1, right, index + 1);
            chars[index] = ')';
            backtrack(output, chars, left, right + 1, index + 1);
        }
    }
}

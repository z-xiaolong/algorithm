package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/2/12 17:12
 * @Title 17. 电话号码的字母组合
 * @Description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 **/

public class LetterCombinations {
    public static String[] numbers = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    //回溯
    public List<String> letterCombinations(String digits) {
        List<String> output = new LinkedList<>();
        if ("".equals(digits)) {
            return output;
        }
        char[] chars = new char[digits.length()];
        backtrack(0, digits, output, chars);
        return output;
    }

    public void backtrack(int index, String digits, List<String> output, char[] chars) {
        if (index == digits.length()) {
            output.add(new String(chars));
            return;
        }
        char c = digits.charAt(index);
        String str = numbers[c - '0'];
        for (int i = 0; i < str.length(); i++) {
            chars[index] = str.charAt(i);
            backtrack(index + 1, digits, output, chars);
        }
    }

    public static String getChars(int i) {
        return numbers[i - 2];
    }

    public static String getChars(char c) {
        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
        }
        return null;
    }
}

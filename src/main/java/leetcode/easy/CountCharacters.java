package leetcode.easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/17 11:08
 * @Title 1160. 拼写单词
 * @Description //TODO
 **/

public class CountCharacters {

    public static void main(String[] args) {
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";
        countCharacters(words, chars);
    }

    //暴力法：执行用时 :6 ms, 在所有 Java 提交中击败了89.17%的用户
    // 默认全部为小写
    public static int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] alphabet = new int[26];
        //chars = chars.toLowerCase();
        for (char c : chars.toCharArray()) {
            alphabet[c - 'a']++;
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int[] temp = Arrays.copyOf(alphabet, 26);
            if (match(word, temp)) {
                count += word.length();
            }
        }
        return count;
    }

    public static boolean match(String word, int[] alphabet) {
        for (char c : word.toCharArray()) {
            if (--alphabet[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

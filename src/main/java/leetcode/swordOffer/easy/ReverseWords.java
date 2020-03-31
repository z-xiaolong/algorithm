package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/3/19 11:00
 * @Title 面试题58 - I. 翻转单词顺序
 * @Description //TODO
 **/

public class ReverseWords {

    //执行用时 :6 ms, 在所有 Java 提交中击败了42.51%的用户
    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return "";
        }
        String[] strings = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i > 0; i--) {
            stringBuilder.append(strings[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.append(strings[0]);
        return stringBuilder.toString();
    }
}

package leetcode.byteDance;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author long
 * @Date 2020/6/21 9:10
 * @Title 翻转字符串里的单词
 * @Description //TODO
 **/

public class ReverseWords {

    public String reverseWords(String s) {
        Deque<String> queue = new LinkedList<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            while (right < s.length() && s.charAt(right) == ' ') {
                right++;
            }
            left = right;
            while (right < s.length() && s.charAt(right) != ' ') {
                right++;
            }
            if (left != right)
                queue.addFirst(s.substring(left, right));
        }
        StringBuilder builder = new StringBuilder();
        while (queue.size() > 1) {
            builder.append(queue.pollFirst());
            builder.append(' ');
        }
        if (!queue.isEmpty())
            builder.append(queue.pollFirst());
        if (builder.length() == 0) return "";
        return builder.toString();
    }
}

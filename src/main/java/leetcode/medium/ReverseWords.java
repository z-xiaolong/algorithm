package leetcode.medium;

import algorithm.chapter10.MyStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author long
 * @Date 2020/4/10 10:03
 * @Title 151. 翻转字符串里的单词
 * @Description //TODO
 **/

public class ReverseWords {

    public static void main(String[] args) {
        String s = "fdsfs";
        //System.out.println(reverseWords("  hello world! "));
    }

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }


    //利用栈：执行用时 :12 ms, 在所有 Java 提交中击败了19.81%的用户
    public static String reverseWordsI(String s) {
        int index = s.length() - 1;
        if (index < 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        MyStack<Character> myStack = new MyStack<>();
        while (index >= 0) {
            char c = s.charAt(index);
            if (c != ' ') {
                myStack.push(c);
            } else {
                if (!myStack.isEmpty()) {
                    while (!myStack.isEmpty()) {
                        stringBuilder.append(myStack.pop());
                    }
                    stringBuilder.append(' ');
                }
            }
            index--;
        }
        if (!myStack.isEmpty()) {
            while (!myStack.isEmpty()) {
                stringBuilder.append(myStack.pop());
            }
            return stringBuilder.toString();
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}

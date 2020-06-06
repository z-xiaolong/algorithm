package leetcode.hard;

import javaCore.test.IntegerTest;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/5/8 22:27
 * @Title 224. 基本计算器
 * @Description //TODO
 **/

public class Calculate {

    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        int length = s.length();
        while (i < length) {
            int j = i;
            if (s.charAt(i) == '(') {
                i++;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                i++;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    i++;
                }
            }
            i++;
        }
        return 0;
    }


}

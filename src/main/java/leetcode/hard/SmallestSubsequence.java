package leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author long
 * @Date 2021/10/3 14:57
 * @Title
 * @Description //TODO
 **/

public class SmallestSubsequence {

    public static void main(String[] args) {
        SmallestSubsequence smallestSubsequence = new SmallestSubsequence();
        smallestSubsequence.smallestSubsequence("aaabbbc", 3, 'b', 2);
    }

    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int n = s.length();
        int cnt = 0;
        Deque<Character> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == letter) cnt++;
        }
        int letterCnt = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && stack.size() - 1 + n - i > k) {
                if (stack.peek() == letter) {
                    if (letterCnt + cnt - 1 < repetition) break;
                    letterCnt--;
                }
                stack.pop();
            }
            if (c == letter) {
                letterCnt++;
                cnt--;
            }
            stack.push(c);
        }
        StringBuilder builder = new StringBuilder();
        while (stack.size() > k) {
            if (stack.pop() == letter) {
                if (letterCnt <= repetition) {
                    builder.append(letter);
                    k--;
                }
                letterCnt--;
            }
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}

package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2021/4/1 10:10
 * @Title
 * @Description //TODO
 **/

public class Clumsy {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<int[]> output = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                output.add(new int[]{stack.pop(), i});
            }
        }
        output.sort(Comparator.comparingInt(o -> o[0]));
        System.out.println(output.size());
        for (int[] out : output) {
            System.out.println(out[0]);
            System.out.println(out[1]);
        }
    }

    public static void dfs(List<String> list, char[] chars, int index) {
        if (index == chars.length) {
            list.add(String.valueOf(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            dfs(list, chars, index + 1);
            swap(chars, index, i);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        if (i == j) {
            return;
        }
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }


    public int clumsy(int N) {

        Deque<Integer> stack = new ArrayDeque<>();
        char[] operation = new char[]{'*', '/', '+', '-'};
        int j = 0;
        stack.push(N);
        for (int i = N - 1; i >= 1; i--, j++) {
            char opt = operation[j % 4];
            if (opt == '*') {
                stack.push(stack.pop() * i);
            } else if (opt == '/') {
                stack.push(stack.pop() / i);
            } else if (opt == '+') {
                stack.push(i);
            } else {
                stack.push(-i);
            }
        }
        int res = 0;
        for (Integer num : stack) {
            res += num;
        }
        return res;
    }
}

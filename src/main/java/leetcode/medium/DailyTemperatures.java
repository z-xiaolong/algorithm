package leetcode.medium;


import java.util.Stack;

/**
 * @Author long
 * @Date 2020/4/15 11:29
 * @Title 739. 每日温度
 * @Description //TODO
 **/

public class DailyTemperatures {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    //利用栈：执行用时 :29 ms, 在所有 Java 提交中击败了57.86%的用户
    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        if (length == 0) return new int[0];
        int[] result = new int[length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, T[0]});
        for (int i = 1; i < length; i++) {
            int[] prev = stack.peek();
            while (T[i] > prev[1]) {
                result[prev[0]] = i - prev[0];
                stack.pop();
                if (stack.size() == 0) break;
                prev = stack.peek();
            }
            stack.push(new int[]{i, T[i]});
        }
        return result;
    }

    //优化后：执行用时 :4 ms, 在所有 Java 提交中击败了99.32%的用户
    public static int[] dailyTemperaturesII(int[] T) {
        int length = T.length;
        if (length == 0) return new int[0];
        int[] result = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < length) {
                if (T[i] < T[j]) {
                    result[i] = j - i;
                    break;
                } else if (T[i] >= T[j] && result[j] > 0) {
                    j += result[j];
                } else {
                    break;
                }
            }
        }
        return result;
    }

    //暴力解：执行用时 :1969 ms, 在所有 Java 提交中击败了5.01%的用户
    public int[] dailyTemperaturesI(int[] T) {
        int length = T.length;
        if (length == 0) return new int[0];
        int[] result = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}

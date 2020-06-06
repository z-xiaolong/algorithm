package leetcode.hard;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/2/16 15:42
 * @Title 85. 最大矩形
 * @Description 给定一个仅包含 0 和 1 的二维二进制矩阵，
 * 找出只包含 1 的最大矩形，并返回其面积。
 **/

public class MaximalRectangle {


    //执行用时 :11 ms, 在所有 Java 提交中击败了55.88%的用户
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int max = 0;
        int columns = matrix[0].length;
        int[] dp = new int[columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    dp[j] = dp[j] + 1;
                } else {
                    dp[j] = 0;
                }
            }
            max = Math.max(max, area(dp));
        }
        return max;
    }

    public int area(int[] dp) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            while (stack.peek() != -1 && dp[i] < dp[stack.peek()]) {
                int area = dp[stack.pop()] * (i - stack.peek() - 1);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int area = dp[stack.pop()] * (dp.length - stack.peek() - 1);
            max = Math.max(max, area);
        }
        return max;
    }
}

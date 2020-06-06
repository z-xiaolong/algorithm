package leetcode.hard;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/4/22 11:23
 * @Title 84. 柱状图中最大的矩形
 * @Description //TODO
 **/

public class LargestRectangleArea {

    public static void main(String[] args) {
        LargestRectangleArea area = new LargestRectangleArea();
        area.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    //单调栈：执行用时 :14 ms, 在所有 Java 提交中击败了69.66%的用户
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();//单调栈，保存数组索引
        stack.push(-1);//避免栈越界
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int area = heights[stack.pop()] * (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int area = heights[stack.pop()] * (heights.length - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    //暴力解: 执行用时 :1183 ms, 在所有 Java 提交中击败了7.50%的用户
    public int largestRectangleAreaI(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, getArea(heights, i));
        }
        return max;
    }

    public int getArea(int[] heights, int index) {
        int left = index;
        int right = index;
        while (left >= 0 && heights[left] >= heights[index]) {
            left--;
        }
        while (right < heights.length && heights[right] >= heights[index]) {
            right++;
        }
        return heights[index] * (right - left - 1);
    }
}

package leetcode.swordOffer.hard;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/5/30 9:19
 * @Title 84. 柱状图中最大的矩形
 * @Description //TODO
 **/

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (stack.size() > 1 && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int top = stack.pop();
                int left = stack.peek();
                maxArea = Math.max(maxArea, (i - left - 1) * heights[top]);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

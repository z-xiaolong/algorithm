package leetcode.swordOffer.hard;

import java.util.Map;

/**
 * @Author long
 * @Date 2020/4/4 17:30
 * @Title 42. 接雨水
 * @Description //TODO
 **/

public class Trap {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 2, 3, 1, 5};
        Trap trap = new Trap();
        trap.trap(nums);
    }

    //双指针优化：执行用时 :1 ms, 在所有 Java 提交中击败了99.98%的用户
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    sum += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    sum += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return sum;
    }

    //双指针
    public int trapI(int[] height) {
        int length = height.length;
        if (length < 2) {
            return 0;
        }
        int sum = 0;
        int left = 0;
        int right = 1;
        while (right < length) {
            if (height[left] > height[right]) {
                right++;
            } else {
                sum += getTrap(height, left, right);
                left = right++;
            }
        }
        int max = left;
        right = length - 1;
        left = right - 1;
        while (left > max) {
            if (height[right] > height[left]) {
                left--;
            } else {
                sum += getTrap(height, left, right);
                right = left--;
            }
        }
        return sum;
    }

    public int getTrap(int[] height, int i, int j) {
        int min = Math.min(height[i], height[j]);
        int sum = 0;
        for (int k = i + 1; k < j; k++) {
            sum += min - height[k];
        }
        return sum;
    }
}

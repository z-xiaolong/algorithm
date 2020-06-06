package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/4/18 9:35
 * @Title 11. 盛最多水的容器
 * @Description //TODO
 **/

public class MaxArea {
    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    //双指针：执行用时 :3 ms, 在所有 Java 提交中击败了92.77%的用户
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int area;
        while (left < right) {
            if (height[left] <= height[right]) {
                area = height[left] * (right - left);
                while (right > left && height[left] >= height[left + 1]) {
                    left++;
                }
                left++;
            } else {
                area = height[right] * (right - left);
                while (right > left && height[right] >= height[right - 1]) {
                    right--;
                }
                right--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}

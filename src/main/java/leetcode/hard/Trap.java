package leetcode.hard;

/**
 * @Author long
 * @Date 2019/12/25 13:30
 * @Title 42. 接雨水
 * @Description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 **/

public class Trap {

    public static void main(String[] args) {
        int[] array = new int[]{10, 2, 2, 2, 1, 2, 3};
        Trap trap = new Trap();
        System.out.println(trap.trap(array));
    }

    public int trap(int[] height) {
        int limit = height.length;
        int sum = 0;
        int low = 0;
        int high = low + 1;
        while (low < limit && high < limit) {
            if (height[high] < height[low]) {
                high++;
            } else {
                sum = sum + concave(height, low, high);
                low = high;
                high = low + 1;
            }
        }
        limit = low;
        low = high - 1;
        high = low - 1;
        while (low >= limit && high >= limit) {
            if (height[high] < height[low]) {
                high--;
            } else {
                sum = sum + concave(height, high, low);
                low = high;
                high = low - 1;
            }
        }
        return sum;
    }

    public int concave(int[] height, int head, int tail) {
        if (head == tail - 1) {
            return 0;
        }
        int min = Math.min(height[head], height[tail]);
        int sum = 0;
        for (int i = head + 1; i < tail; i++) {
            sum = sum + min - height[i];
        }
        return sum;
    }
}

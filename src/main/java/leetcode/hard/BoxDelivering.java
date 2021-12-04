package leetcode.hard;

import java.util.LinkedList;

/**
 * @Author long
 * @Date 2021/11/18 20:44
 * @Title
 * @Description //TODO
 **/

public class BoxDelivering {

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        //TODO
        return 0;
    }

    public static void main(String[] args) {
        BoxDelivering boxDelivering = new BoxDelivering();
        boxDelivering.maxResult(new int[]{100, -1, -100, -1, 100}, 2);
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        for (int i = 1; i < n; i++) {
            while (!queue.isEmpty() && queue.peek() + k < i) {
                queue.poll();
            }
            dp[i] = dp[queue.peek()] + nums[i];
            while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]) {
                queue.pollLast();
            }
            queue.add(i);
        }
        return dp[n - 1];
    }
}

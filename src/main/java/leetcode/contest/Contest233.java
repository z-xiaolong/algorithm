package leetcode.contest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2021/3/21 10:03
 * @Title
 * @Description //TODO
 **/

public class Contest233 {
    public static void main(String[] args) {
        //int[][] orders = new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
        //int[][] orders = new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
        //System.out.println(getNumberOfBacklogOrders(orders));
        Contest233 contest = new Contest233();
        contest.maxValue(8, 6, 20);
    }


    public int maxValue(int n, int index, int maxSum) {
        int max = maxSum - n + 1;
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            long sum = midValue(n, index, mid);
            if (sum < maxSum) {
                left = mid;
            } else if (sum > maxSum) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public long midValue(int n, int index, int mid) {
        long sum = 0;
        if (mid > index) {
            sum += (long) (mid + mid - index) * (index + 1) / 2;
        } else {
            sum += (long) (mid + 1) * mid / 2 + index - mid + 1;
        }
        if (mid > n - index) {
            sum += (long) (mid + mid - n + index + 1) * (n - index) / 2;
        } else {
            sum += (long) (mid + 1) * mid / 2 + n - index - mid;
        }
        return sum - mid;
    }

    public static int getNumberOfBacklogOrders(int[][] orders) {
        int mod = 1000000007;
        PriorityQueue<int[]> sells = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        PriorityQueue<int[]> buys = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (!sells.isEmpty() && sells.peek()[0] <= order[0] && order[1] > 0) {
                    int[] sell = sells.poll();
                    if (sell[1] >= order[1]) {
                        sell[1] -= order[1];
                        order[1] = 0;
                        sells.add(sell);
                    } else {
                        order[1] -= sell[1];
                    }
                }
                if (order[1] > 0) {
                    buys.add(order);
                }
            } else {
                while (!buys.isEmpty() && buys.peek()[0] >= order[0] && order[1] > 0) {
                    int[] buy = buys.poll();
                    if (buy[1] >= order[1]) {
                        buy[1] -= order[1];
                        order[1] = 0;
                        buys.add(buy);
                    } else {
                        order[1] -= buy[1];
                    }
                }
                if (order[1] > 0) {
                    sells.add(order);
                }
            }
        }
        long backlog = 0;
        for (int[] buy : buys) {
            backlog = (backlog + buy[1]) % mod;
        }
        for (int[] sell : sells) {
            backlog = (backlog + sell[1]) % mod;
        }
        return (int) backlog;
    }


    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}

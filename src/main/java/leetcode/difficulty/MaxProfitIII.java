package leetcode.difficulty;

/**
 * @Author long
 * @Date 2020/2/25 14:02
 * @Title 123. 买卖股票的最佳时机 III
 * @Description 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 **/

public class MaxProfitIII {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 1};
        MaxProfitIII maxProfitIII = new MaxProfitIII();
        maxProfitIII.maxProfit(nums);
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int max = 0;
        int min = 0;
        int left = 0;
        int right = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[min]) {
                min = i;
            } else if (prices[i] - prices[min] > max) {
                max = prices[i] - prices[min];
                right = i;
                left = min;
            }
        }
        int leftSub = subMaxProfit(prices, 0, left - 1);
        int rightSub = subMaxProfit(prices, right + 1, prices.length - 1);
        int subMax = Math.max(leftSub, rightSub);
        int subMin = subMinProfit(prices, left, right);
        return Math.max(max + subMax, max + subMin);
    }

    public int subMinProfit(int[] prices, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int min = prices[right];
        int max = 0;
        for (int i = right - 1; i >= left; i--) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public int subMaxProfit(int[] prices, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int max = 0;
        int min = prices[left];
        for (int i = left + 1; i <= right; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}

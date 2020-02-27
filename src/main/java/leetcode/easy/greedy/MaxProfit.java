package leetcode.easy.greedy;

/**
 * @Author long
 * @Date 2020/2/25 11:31
 * @Title 122. 买卖股票的最佳时机 II
 * @Description 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 **/

public class MaxProfit {

    public int maxProfitGreedy(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int sum = 0;
        int max = prices[0];
        int min = max;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            } else if (prices[i] < max) {
                sum += max - min;
                max = prices[i];
                min = max;
            }
        }
        sum += max - min;
        return sum;
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    // 121. 买卖股票的最佳时机 I
    //方法一：转化为最长子序列和问题
    public int maxProfitI(int[] prices) {
        int sum = 0;
        int max = 0;
        int length = prices.length;
        int[] sub = new int[length];
        for (int i = 1; i < length; i++) {
            sub[i - 1] = prices[i] - prices[i - 1];
        }
        for (int i = 0; i < sub.length - 1; i++) {
            if (sum > 0) {
                sum += sub[i];
            } else {
                sum = sub[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    //方法二：动态规划
    public int maxProfitII(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}

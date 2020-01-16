package leetcode.easy;

/**
 * @Author long
 * @Date 2019/10/7 10:49
 * @Description 给定一个数组，它的第i个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(array));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minPrice < prices[i]) {
                if (maxProfit < (prices[i] - minPrice)) {
                    maxProfit = prices[i] - minPrice;
                }
            } else {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}

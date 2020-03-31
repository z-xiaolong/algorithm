package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/3/10 13:23
 * @Title 面试题63. 股票的最大利润
 * @Description //TODO
 **/

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}

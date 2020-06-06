package leetcode.medium;

/**
 * @Author long
 * @Date 2020/5/6 9:08
 * @Title 983. 最低票价
 * @Description //TODO
 **/

public class MincostTickets {

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{2, 7, 15};
        MincostTickets mincostTickets = new MincostTickets();
        mincostTickets.mincostTickets(days, costs);
    }

    public int mincostTickets(int[] days, int[] costs) {
        int endDay = days[days.length - 1]; //最后乘火车的日期
        int[] dp = new int[endDay + 30]; //400 防止越界
        for (int i = endDay, j = days.length - 1; i >= 0 && j >= 0; i--) {
            if (i == days[j]) {
                //dp[i] 表示在第i天买车票花费的最小代价
                // dp[i] = Min(dp[i+1] costs[0],dp[i + 7] + costs[1],dp[i + 30] + costs[2])
                dp[i] = Math.min(dp[i + 1] + costs[0], dp[i + 7] + costs[1]);
                dp[i] = Math.min(dp[i], dp[i + 30] + costs[2]);
                j--;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[days[0]];
    }
}

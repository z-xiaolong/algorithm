package leetcode.medium.dp;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/2/21 16:05
 * @Title 322. 零钱兑换
 * @Description 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 **/

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{1, 2, 5};
        coinChange.coinChange(coins, 11);
    }

    public int coinChange(int[] coins, int amount) {
        int[] nums = new int[amount + 1];
        Arrays.fill(nums, amount + 1);
        nums[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    nums[i] = Math.min(nums[i], nums[i - coin] + 1);
                }
            }

        }
        return nums[amount] == amount + 1 ? -1 : nums[amount];
    }
}

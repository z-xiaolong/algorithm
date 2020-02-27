package leetcode.easy.dp;

/**
 * @Author long
 * @Date 2020/2/16 21:45
 * @Title 746. 使用最小花费爬楼梯
 * @Description 数组的每个索引做为一个阶梯，
 * 第i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，
 * 然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，
 * 你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 **/

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        for (int i = 2; i < length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[length - 1], cost[length - 2]);
    }
}

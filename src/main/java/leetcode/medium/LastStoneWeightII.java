package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2020/5/26 10:31
 * @Title 1049. 最后一块石头的重量 II
 * @Description //TODO
 **/

public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int wight = sum >> 1;
        int[] dp = new int[wight + 1];
        for (int stone : stones) {
            for (int j = wight; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }
        return sum - 2 * dp[wight];
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            if (queue.isEmpty()) queue.add(num);
        }

        int max = 1;

        return max;
    }
}

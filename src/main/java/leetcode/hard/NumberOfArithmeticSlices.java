package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/8/11 11:10
 * @Title
 * @Description //TODO
 **/

public class NumberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Long, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                int cnt = dp[j].getOrDefault(d, 0);
                count += cnt;
                dp[i].put(d, dp[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return count;
    }
}

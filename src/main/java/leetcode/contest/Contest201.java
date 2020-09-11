package leetcode.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: long
 * @Date: 2020/8/9 9:51
 * @Title
 * @Description:
 */
public class Contest201 {

    //整理字符串
    public String makeGood(String s) {
        int index = isSatisfy(s);
        while (index != -1) {
            s = s.substring(0, index) + s.substring(index + 2);
            index = isSatisfy(s);
        }
        return s;
    }

    public int isSatisfy(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32)
                return i;
        }
        return -1;
    }


    //找出第 N 个二进制字符串中的第 K 位
    public char findKthBit(int n, int k) {
        int[] dp = new int[21];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] * 2 + 1;
        }
        return dfs(dp, n, k, true);
    }

    public char dfs(int[] dp, int n, int k, boolean flag) {
        if (k == 1) {
            if (flag) return '0';
            else return '1';
        }
        int length = dp[n];
        int mid = (length + 1) / 2;
        if (k > mid) {
            return dfs(dp, n - 1, dp[n - 1] - (k - mid) + 1, !flag);
        } else if (k < mid) {
            return dfs(dp, n - 1, k, flag);
        } else {
            if (flag) return '1';
            else return '0';
        }
    }


    //和为目标值的最大数目不重叠非空子数组数目
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        Set<Integer> hashMap = new HashSet<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == target || nums[i] == target || hashMap.contains(sum - target)) {
                count++;
                sum = 0;
                hashMap.clear();
                continue;
            }
            hashMap.add(sum);
        }
        return count;
    }



    //5486. 切棍子的最小成本
    public int minCost(int n, int[] cuts) {
        return 0;
    }

    public static void main(String[] args) {
        Contest201 contest = new Contest201();
        int[] nums = new int[]{-2,6,6,3,5,4,1,2,8};
        contest.maxNonOverlapping(nums, 10);
    }
}

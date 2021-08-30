package leetcode.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/2/28 10:22
 * @Title
 * @Description //TODO
 **/

public class Contest230 {

    public static void main(String[] args) {
        Contest230 contest230 = new Contest230();
        int[] nums1 = new int[]{3, 3, 2, 4, 2, 6, 2};
        int[] nums2 = new int[]{6, 2, 6, 6, 1, 1, 4, 6, 4, 6, 2, 5, 4, 2, 1};
        contest230.minOperations(nums1, nums2);
    }


    public boolean isMonotonic(int[] A) {
        int n = A.length;
        boolean inc = false;
        boolean dec = false;
        for (int i = 1; i < n; i++) {
            if (A[i] < A[i - 1]) {
                inc = true;
            }
            if (A[i] > A[i - 1]) {
                dec = true;
            }
            if (inc && dec) {
                return false;
            }
        }
        return true;
    }


    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m * 6 || m > n * 6) {
            return -1;
        }
        int[] map1 = new int[7];
        int[] map2 = new int[7];
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
            map1[num]++;
        }
        for (int num : nums2) {
            sum2 += num;
            map2[num]++;
        }
        if (sum1 > sum2) {
            return min(sum1, sum2, map1, map2);
        } else if (sum1 < sum2) {
            return min(sum2, sum1, map2, map1);
        }
        return 0;
    }

    public int min(int sum1, int sum2, int[] map1, int[] map2) {
        int cnt = 0;
        int left = 6;
        int right = 1;
        while (sum1 - sum2 >= 6) {
            while (sum1 - sum2 >= 6 && map1[left] > 0) {
                sum1 -= left - 1;
                map1[left]--;
                cnt++;
            }
            if (map1[left] == 0) {
                left--;
            }
            while (sum1 - sum2 >= 6 && map2[right] > 0) {
                sum2 += 6 - right;
                map2[right]--;
                cnt++;
            }
            if (map2[right] == 0) {
                right++;
            }
        }
        while (sum1 - left + 1 > sum2 && sum1 > sum2 + 6 - right) {
            if (left - 1 >= 6 - right) {
                map1[left]--;
                sum1 -= left - 1;
                if (map1[left] == 0) {
                    left--;
                }
            } else {
                map2[right]--;
                sum2 += 6 - right;
                if (map2[right] == 0) {
                    right++;
                }
            }
            cnt++;
        }
        return cnt + 1;
    }


    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int ans = Integer.MAX_VALUE;
        for (int baseCost : baseCosts) {
            if (baseCost < target) {
                choice = Integer.MAX_VALUE;
                dfs(toppingCosts, 0, 0, target - baseCost);
            } else {
                ans = update(baseCost, ans, target);
                break;
            }
            ans = update(baseCost + choice, ans, target);
        }
        return ans;
    }

    public int update(int value, int newValue, int target) {
        if (Math.abs(value - target) > Math.abs(newValue - target)) {
            return newValue;
        } else if (Math.abs(value - target) == Math.abs(newValue - target)) {
            return Math.min(value, newValue);
        }
        return value;
    }

    int choice = Integer.MAX_VALUE;

    public void dfs(int[] toppingCosts, int i, int sum, int target) {
        int m = toppingCosts.length;
        if (i == m || sum >= target) {
            choice = update(choice, sum, target);
            return;
        }
        dfs(toppingCosts, i + 1, sum + toppingCosts[i], target);
        dfs(toppingCosts, i + 1, sum + toppingCosts[i] * 2, target);
        dfs(toppingCosts, i + 1, sum, target);
    }


    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> type = new HashMap<>();
        Map<String, Integer> color = new HashMap<>();
        Map<String, Integer> name = new HashMap<>();
        for (List<String> item : items) {
            type.put(item.get(0), type.getOrDefault(item.get(0), 0) + 1);
            color.put(item.get(1), color.getOrDefault(item.get(1), 0) + 1);
            name.put(item.get(2), name.getOrDefault(item.get(2), 0) + 1);
        }
        if ("type".equals(ruleKey)) {
            return type.getOrDefault(ruleValue, 0);
        } else if ("color".equals(ruleKey)) {
            return color.getOrDefault(ruleValue, 0);
        } else if ("name".equals(ruleKey)) {
            return name.getOrDefault(ruleValue, 0);
        }
        return 0;
    }
}

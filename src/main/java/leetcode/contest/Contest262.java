package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2021/10/10 10:26
 * @Title
 * @Description //TODO
 **/

public class Contest262 {

    public static void main(String[] args) {
        Contest262 contest = new Contest262();
    }


    int min = Integer.MAX_VALUE;

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        Map<Integer, int[]> map = new HashMap<>();
        int[][] dp = new int[n / 2 + 1][1 << n];
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j < 1 << n; j++) {

            }
        }
        return 0;
    }

    public void dfs(int[] nums, int sum, int sub, int index, int len) {
        int n = nums.length;
        if (len == n / 2) {
            min = Math.min(min, Math.abs(sum - sub * 2));
            return;
        }
        if (n - index + len < n / 2) return;
        dfs(nums, sum, sub + nums[index], index + 1, len + 1);
        dfs(nums, sum, sub, index + 1, len);
    }

    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[m * n];
        int i = 0;
        for (int[] g : grid) {
            for (int e : g) {
                nums[i++] = e;
            }
        }
        Arrays.sort(nums);
        int ans = 0;
        int mid = m * n / 2;
        for (int num : nums) {
            int abs = Math.abs(num - nums[mid]);
            if (abs % x != 0) return -1;
            ans += abs / x;
        }
        return ans;
    }


    public int minOperations1(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] cnt = new int[10010];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] g : grid) {
            for (int e : g) {
                cnt[e]++;
                min = Math.min(min, e);
                max = Math.max(max, e);
            }
        }
        if ((max - min) % x != 0) return -1;
        int ans = 0;
        while (min < max) {
            while (min < max && cnt[min] == 0) {
                min++;
            }
            while (min < max && cnt[max] == 0) {
                max--;
            }
            if ((max - min) % x != 0) return -1;
            if (max - x == min) {
                if (cnt[max] >= cnt[min]) {
                    ans += cnt[min];
                    cnt[max] += cnt[min];
                    min++;
                } else {
                    ans += cnt[max];
                    cnt[min] += cnt[max];
                    max--;
                }
            }
        }
        return ans;
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
            set.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
            set.add(num);
        }
        for (int num : nums3) {
            set3.add(num);
            set.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for (int num : set) {
            if (set1.contains(num) && set2.contains(num)) {
                ans.add(num);
            } else if (set1.contains(num) && set3.contains(num)) {
                ans.add(num);
            } else if (set2.contains(num) && set3.contains(num)) {
                ans.add(num);
            }
        }
        return ans;
    }
}


class StockPrice {

    Map<Integer, Integer> map = new HashMap<>();
    TreeSet<int[]> set = new TreeSet<>((a, b) -> {
        if (a[1] == b[1]) return a[0] - b[0];
        return a[1] - b[1];
    });
    int cur;

    public StockPrice() {
        cur = 0;
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            set.remove(new int[]{timestamp, map.get(timestamp)});
        }
        set.add(new int[]{timestamp, price});
        map.put(timestamp, price);
        if (timestamp > cur) cur = timestamp;
    }

    public int current() {
        return map.get(cur);
    }

    public int maximum() {
        return set.last()[1];
    }

    public int minimum() {
        return set.first()[1];
    }
}

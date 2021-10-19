package leetcode.hard;

import java.util.*;

/**
 * @Author long
 * @Date 2021/10/10 21:44
 * @Title
 * @Description //TODO
 **/

public class MinimumDifference {


    public static int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int sum = Arrays.stream(nums).sum();
        int ans = Integer.MAX_VALUE;
        TreeSet<int[]>[] left = new TreeSet[n + 1];
        TreeSet<int[]>[] right = new TreeSet[n + 1];
        for (int i = 0; i <= n; i++) {
            left[i] = new TreeSet<>(Comparator.comparingInt(a -> a[1]));
            right[i] = new TreeSet<>(Comparator.comparingInt(a -> a[1]));
        }
        left[0].add(new int[]{0, 0});
        right[0].add(new int[]{0, 0});
        for (int i = 1; i <= n; i++) {
            for (int[] num : left[i - 1]) {
                for (int j = 0; j < n; j++) {
                    if ((num[0] & (1 << j)) == 0) {
                        left[i].add(new int[]{num[0] | (1 << j), num[1] + nums[j]});
                    }
                }
            }
            for (int[] num : right[i - 1]) {
                for (int j = 0; j < n; j++) {
                    if ((num[0] & (1 << j)) == 0) {
                        right[i].add(new int[]{num[0] | (1 << j), num[1] + nums[j + n]});
                    }
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int[] l : left[i]) {
                int[] r = right[n - i].ceiling(l);
                if (r != null)
                    ans = Math.min(ans, Math.abs(sum - (l[1] + r[1]) * 2));
                r = right[n - i].floor(l);
                if (r != null)
                    ans = Math.min(ans, Math.abs(sum - (l[1] + r[1]) * 2));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        divide(100, 3);
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        boolean sign = false;
        int ans = 0;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) sign = true;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        Deque<Integer> candidate = new LinkedList<>();
        candidate.push(b);
        while (candidate.peek() >= a - candidate.peek()) {
            candidate.push(candidate.peek() + candidate.peek());
        }
        while (!candidate.isEmpty()) {
            int num = candidate.pop();
            if (num >= a) {
                ans += 1 << candidate.size();
                a -= num;
            }
        }
        return sign ? -ans : ans;
    }


}

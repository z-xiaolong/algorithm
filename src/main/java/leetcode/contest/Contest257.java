package leetcode.contest;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author long
 * @Date 2021/9/5 10:36
 * @Title
 * @Description //TODO
 **/

public class Contest257 {

    public static void main(String[] args) {
        divide(15,2);
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int ans = 0;
        int bit = 31;
        long m = Math.abs((long)a);
        long n = Math.abs((long)b);
        while (m >= n && bit >= 0) {
            if ((n << bit) <= m) {
                ans += 1 << bit;
                m -= n << bit;
            }
            bit -= 1;
        }
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            return -ans;
        }
        return ans;
    }


    //dp[i] = dp[i-1] + dp[i-1] - dp[next[i-1]] + 2;
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int mod = (int) (1e9 + 7);
        int n = nextVisit.length;
        long[] dp = new long[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = (mod + dp[i - 1] * 2 - dp[nextVisit[i - 1]] + 2) % mod;
        }
        return (int) dp[n - 1];
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        int count = 0;
        int n = properties.length;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && properties[stack.peek()][1] <= properties[i][1]) {
                stack.pop();
            }
            if (!stack.isEmpty() && properties[stack.peek()][1] > properties[i][1]) {
                count++;
            }
            stack.push(i);
        }
        return count;
    }

    public static int countQuadruplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    for (int l = k + 1; l < n; l++) {
                        if (sum == nums[l]) ans++;
                    }
                }
            }
        }
        return ans;
    }
}

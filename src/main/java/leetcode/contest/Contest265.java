package leetcode.contest;

import leetcode.entity.ListNode;

import java.util.*;

/**
 * @Author long
 * @Date 2021/10/31 10:12
 * @Title
 * @Description //TODO
 **/

public class Contest265 {
    public static void main(String[] args) {
        Contest265 contest = new Contest265();
        contest.minimumOperations(new int[]{1, 3}, 6, 4);
    }

    public boolean possiblyEquals(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][][][] dp = new int[n][n][m][m];
        return false;
    }


    public int dp(int[][][][] dp, String s1, String s2, int i, int j, int p, int q) {
        int n = s1.length();
        int m = s2.length();
        if (j >= n || q >= m) return -1;
        if (i > j || p > q) {
            dp[i][j][p][q] = -1;
            return -1;
        }
        if (dp[i][j][p][q] != 0) return dp[i][j][p][q];
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if (Character.isLetter(c1) && Character.isLetter(c2)) {
            if (c1 == c2)
                dp[i][j][p][q] = dp(dp, s1, s2, i + 1, j, p + 1, q);
            else {
                dp[i][j][p][q] = -1;
                return -1;
            }
        } else if (Character.isLetter(c1)) {
            int num = c2 - '0';
            dp[i][j][p][q] = dp(dp, s1, s2, i + num, j, p + 1, q);
        }
        return 0;
    }

    public int minimumOperations(int[] nums, int start, int goal) {
        if (start == goal) return 0;
        Set<Integer> set = new HashSet<>();
        set.add(start);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int k = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int i = queue.poll();
                for (int num : nums) {
                    int add = i + num;
                    int sub = i - num;
                    int xor = i ^ num;
                    if (add == goal || sub == goal || xor == goal) return k;
                    if (!set.contains(add) && add >= 0 && add <= 1000) {
                        set.add(add);
                        queue.add(add);
                    }
                    if (!set.contains(sub) && sub >= 0 && sub <= 1000) {
                        set.add(sub);
                        queue.add(sub);
                    }
                    if (!set.contains(xor) && xor >= 0 && xor <= 1000) {
                        set.add(xor);
                        queue.add(xor);
                    }
                }
                size--;
            }
            k++;
        }
        return -1;
    }


    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        ListNode prev = head;
        head = head.next;
        int k = 1;
        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            if (head.val > prev.val && head.val > head.next.val) {
                list.add(k);
            } else if (head.val < prev.val && head.val < head.next.val) {
                list.add(k);
            }
            k++;
            prev = head;
            head = head.next;
        }
        if (list.size() < 2) return ans;
        int min = Integer.MAX_VALUE;
        ans[1] = list.get(list.size() - 1) - list.get(0);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        ans[0] = min;
        return ans;
    }

    public int smallestEqual(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i % 10 == nums[i]) return i;
        }
        return -1;
    }

}
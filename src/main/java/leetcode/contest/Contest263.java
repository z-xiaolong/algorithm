package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2021/10/17 10:23
 * @Title
 * @Description //TODO
 **/

public class Contest263 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        Contest263 contest = new Contest263();
        contest.secondMinimum(5, edges, 3, 5);
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(second, Integer.MAX_VALUE);
        first[1] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0}); //节点 时间点
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int nextTime = next(node[1], time, change);
            for (int nextNode : adj[node[0]]) {
                if (first[nextNode] > nextTime) {
                    second[nextNode] = first[nextNode];
                    first[nextNode] = nextTime;
                    queue.add(new int[]{nextNode, nextTime});
                }
                if (second[nextNode] > nextTime && first[nextNode] < nextTime) {
                    second[nextNode] = nextTime;
                    queue.add(new int[]{nextNode, nextTime});
                }
            }
        }
        if (second[n] != Integer.MAX_VALUE) return second[n];
        return next(next(first[n], time, change), time, change);
    }

    private int next(int curTime, int time, int change) {
        if ((curTime / change) % 2 == 0) {
            return curTime + time;
        }
        return change - (curTime % change) + curTime + time;
    }

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int or = 0;
        for (int num : nums) {
            or = or | num;
        }
        int[] dp = new int[1 << n];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    dp[i] = dp[i - (1 << j)] | nums[j];
                    break;
                }
            }
        }
        int cnt = 0;
        for (int j : dp) {
            if (j == or) cnt++;
        }
        return cnt;
    }


    public boolean areNumbersAscending(String s) {
        String[] strs = s.split(" ");
        int prev = Integer.MIN_VALUE;
        for (String str : strs) {
            if (isNumber(str)) {
                int cur = Integer.parseInt(str);
                if (cur <= prev) return false;
                prev = cur;
            }
        }
        return true;
    }


    public boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }
}


class Bank {

    private long[] balance;
    private int n;

    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > n || account1 < 1) return false;
        if (account2 > n || account2 < 1) return false;
        if (balance[account1 - 1] < money) return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > n || account < 1) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > n || account < 1) return false;
        if (balance[account - 1] < money) return false;
        balance[account - 1] -= money;
        return true;
    }
}


package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2021/9/11 14:34
 * @Title
 * @Description //TODO
 **/

public class Lccup21 {


    public static void main(String[] args) {
        Lccup21 lccup21 = new Lccup21();
        long[] ch = new long[]{95, 1, 95, 95, 95, 6};
        lccup21.valid(ch, 90);
        System.out.println(lccup21.ringGame(ch));
        long[] ch1 = new long[]{5, 4, 6, 2, 7};
        lccup21.ringGame(ch1);
    }

    public long ringGame(long[] challenge) {
        long max = Long.MIN_VALUE;
        for (long c : challenge) {
            max = Math.max(max, c);
        }
        int cnt = bitCount(max) - 1;
        long ans = 1L << cnt;
        for (long cur = ans >> 1; cur > 0; cur >>= 1) {
            long score = ans | (cur - 1);
            if (score <= max && !valid(challenge,score)) {
                ans |= cur;
            }
        }
        return ans;
    }

    public boolean valid(long[] challenge, long score) {
        int n = challenge.length;
        LinkedList<Long> queue = new LinkedList<>();
        int right = n - 1;
        int left = 0;
        long tmp = score;
        while (left <= right) {
            boolean flag = false;
            while (left <= right && tmp >= challenge[left]) {
                tmp |= challenge[left];
                left++;
                flag = true;
            }
            while (!queue.isEmpty() && tmp >= queue.peekFirst()) {
                tmp |= queue.poll();
                flag = true;
            }
            while (left <= right && queue.isEmpty() && tmp >= challenge[right]) {
                tmp |= challenge[right];
                right--;
                flag = true;
            }
            if (!flag) {
                if (tmp > score)
                    queue.addFirst(tmp);
                queue.addFirst(challenge[left]);
                left++;
                tmp = score;
            }
        }
        while (!queue.isEmpty() && tmp >= queue.peekFirst()) {
            tmp |= queue.pollFirst();
        }
        while (!queue.isEmpty() && tmp >= queue.peekLast()) {
            tmp |= queue.pollLast();
        }
        return queue.isEmpty();
    }

    public int bitCount(long max) {
        int cnt = 0;
        while (max != 0) {
            max >>= 1;
            cnt++;
        }
        return cnt;
    }

    int mod = 1000000007;

    public int securityCheck(int[] capacities, int k) {
        int n = capacities.length;
        int[] stacks = new int[n];
        for (int i = 0; i < n; i++) {
            stacks[i] = capacities[i] - 1;
        }
        long[] dp = new long[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= stacks[i]; j--) {
                dp[j] = (dp[j] + dp[j - stacks[i]]) % mod;
            }
        }
        return (int) dp[k];
    }


    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        int n = finalCnt.length;
        int[] x = new int[n + 1];
        x[0] = 1;
        Set<Integer>[] neighbors = new Set[n + 1];
        for (int i = 0; i <= n; i++) {
            neighbors[i] = new HashSet<>();
        }
        for (int[] edg : edges) {
            neighbors[edg[0]].add(edg[1]);
            neighbors[edg[1]].add(edg[0]);
        }
        long[] finalCount = new long[n + 1];
        for (int i = 0; i < n; i++) {
            finalCount[i + 1] = finalCnt[i];
        }
        for (int i = plans.length - 1; i >= 0; i--) {
            int num = plans[i][0];
            int idx = plans[i][1];
            if (num == 1) {
                finalCount[idx] *= 2;
                x[idx] *= 2;
            } else if (num == 2) {
                for (int next : neighbors[idx]) {
                    finalCount[next] -= finalCount[idx];
                    x[next] -= x[idx];
                }
            } else if (num == 3) {
                for (int next : neighbors[idx]) {
                    finalCount[next] += finalCount[idx];
                    x[next] += x[idx];
                }
            }
        }
        long sum = Arrays.stream(finalCount).sum();
        int cnt = Arrays.stream(x).sum();
        long zero = (totalNum - sum) / cnt;
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = (int) (x[i] * zero + finalCount[i]);
        }
        return ans;
    }

    //团队赛
    int[] X = new int[]{0, 0, 1, -1};
    int[] Y = new int[]{1, -1, 0, 0};

    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        int n = terrain.length;
        int m = terrain[0].length;
        Set<Integer>[][] dp = new Set[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        dp[position[0]][position[1]].add(1);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(position);
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + X[i];
                int newY = y + Y[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    int diff = terrain[x][y] - terrain[newX][newY] - obstacle[newX][newY];
                    for (int speed : dp[x][y]) {
                        speed += diff;
                        if (speed > 0 && !dp[newX][newY].contains(speed)) {
                            dp[newX][newY].add(speed);
                            queue.add(new int[]{newX, newY});
                        }
                    }
                }
            }
        }
        dp[position[0]][position[1]].clear();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j].contains(1)) {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list.toArray(new int[][]{});
    }


    //个人赛
    public int flipChess(String[] chessboard) {
        return 0;
    }

    public int maxmiumScore(int[] cards, int cnt) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int card : cards) {
            if (card % 2 == 0) even.add(card);
            else odd.add(card);
        }
        Collections.sort(even);
        Collections.sort(odd);
        int[] preEven = new int[even.size() + 1];
        int[] preOdd = new int[odd.size() + 1];
        for (int i = 1; i < preEven.length; i++) {
            preEven[i] = even.get(i - 1) + preEven[i - 1];
        }
        for (int i = 1; i < preOdd.length; i++) {
            preOdd[i] = odd.get(i - 1) + preOdd[i - 1];
        }
        int max = 0;
        for (int i = 0; i <= odd.size() && cnt - i >= 0; i += 2) {
            if (cnt - i > even.size()) continue;
            max = Math.max(max,
                    preEven[preEven.length - 1] - preEven[preEven.length - cnt + i - 1] + preOdd[preOdd.length - 1] - preOdd[preOdd.length - i - 1]);
        }
        return max;
    }


    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int[] s = new int[10010];
        int[] t = new int[10010];
        int ans = 0;
        int n = source.length;
        int m = source[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[source[i][j]]++;
                t[target[i][j]]++;
            }
        }
        for (int i = 0; i < s.length; i++) {
            if (t[i] > s[i]) {
                ans += t[i] - s[i];
            }
        }
        return ans;
    }
}

package exam;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;


/**
 * @Author long
 * @Date 2020/4/8 18:51
 * @Title
 * @Description //TODO
 **/


/*
*
4 4 100 2 2
0 -1 1 2
3 1 5 1
1 -1 -1 -1
1 1 -1 0
*
* */
public class WeBank {


    static int max = 0;
    static int startX;
    static int startY;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int K = in.nextInt();
        startX = in.nextInt() - 1;
        startY = in.nextInt() - 1;
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        bfs(a, b, startX, startY);
        boolean[][] flag = new boolean[n][m];
        dfs(a, b, flag, startX, startY, K, 0);
        System.out.println(max);
    }

    static int[] X = new int[]{0, 1, -1, 0};
    static int[] Y = new int[]{1, 0, 0, -1};

    public static void bfs(int[][] a, int[][] b, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int n = a.length;
        int m = a[0].length;
        boolean[][] flag = new boolean[n][m];
        flag[x][y] = true;
        queue.add(new int[]{x, y});
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size > 0) {
                int[] v = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = v[0] + X[i];
                    int newY = v[1] + Y[i];
                    if (newX < n && newX >= 0 && newY < m && newY >= 0
                            && a[newX][newY] >= 0 && !flag[newX][newY]) {
                        queue.add(new int[]{newX, newY});
                        b[newX][newY] = step;
                        flag[newX][newY] = true;
                    }
                }
                size--;
            }
        }
    }

    public static void dfs(int[][] a, int[][] b, boolean[][] flag, int x, int y, int K, int sum) {
        if (b[x][y] > K) {
            return;
        }
        if (K == 0) {
            if (x == startX && y == startY) {
                max = Math.max(max, sum);
                return;
            }
        }
        int n = a.length;
        int m = a[0].length;
        sum += a[x][y];
        flag[x][y] = true;
        if (b[x][y] <= K) {
            max = Math.max(max, sum);
        }
        if (x + 1 < n && a[x + 1][y] >= 0 && !flag[x + 1][y]) {
            dfs(a, b, flag, x + 1, y, K - 1, sum);
        }
        if (y + 1 < m && a[x][y + 1] >= 0 && !flag[x][y + 1]) {
            dfs(a, b, flag, x, y + 1, K - 1, sum);
        }
        if (x - 1 >= 0 && a[x - 1][y] >= 0 && !flag[x - 1][y]) {
            dfs(a, b, flag, x - 1, y, K - 1, sum);
        }
        if (y - 1 >= 0 && a[x][y - 1] >= 0 && !flag[x][y - 1]) {
            dfs(a, b, flag, x, y - 1, K - 1, sum);
        }
        flag[x][y] = false;
    }


    static long sum = 0;

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        long count = 0;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] <= nums[j] && nums[j] <= nums[k]) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int[] nums, int index, int count, int pre) {
        if (index == nums.length) {
            if (count >= 3) {
                sum += (count - 1) * (count - 2) * count / 6;
            }
            return;
        }
        for (int i = index; i <= nums.length; i++) {
            if (pre == -1) {
                dfs(nums, i + 1, count + 1, i);
                continue;
            }
            if (i == nums.length) {
                dfs(nums, nums.length, count, i);
                return;
            }
            if (nums[i] >= nums[pre]) {
                dfs(nums, i + 1, count + 1, i);
            }
        }
    }


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < q; i++) {
            int query = in.nextInt();
            System.out.println(search(a, query));
        }
    }

    public static int search(int[] a, int query) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > query) {
                right = mid - 1;
            } else if (a[mid] < query) {
                left = mid + 1;
            } else {
                return query;
            }
        }
        if (left != a.length - 1 && left != 0) {
            if (Math.abs(a[left] - query) > Math.abs(a[left + 1] - query)) {
                left++;
            }
            if (Math.abs(a[left] - query) >= Math.abs(a[left - 1] - query)) {
                left--;
            }
        }
        return a[left];
    }


    public static void main11(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] dp = new int[n + 1][n * m];
        if (m % n == 0) {
            System.out.println(0);
            return;
        }
        int min = minCost(dp, n, m, a, b);
        System.out.println(min);
    }

    //分礼物
    public static int minCost(int[][] dp, int n, int m, int a, int b) {
        if (m % n == 0) return 0;
        if (dp[n][m] != 0) return dp[n][m];
        int res1 = minCost(dp, n - 1, m, a, b) + a;
        int res2 = minCost(dp, n, m + 1, a, b) + b;
        dp[n][m] = Math.min(res1, res2);
        return dp[n][m];
    }


    //回文游戏
    public static boolean getWinner(String str) {
        int[] chars = new int[26];
        for (char c : str.toCharArray()) {
            chars[c - 'a']++;
        }
        boolean res = true;
        while (!check(chars)) {
            delete(chars);
            res = false;
        }
        return res;
    }

    public static boolean check(int[] chars) {
        int count = 0;
        for (int num : chars) {
            if (num % 2 == 1) {
                count++;
            }
        }
        return count < 2;
    }

    public static void delete(int[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0 && chars[i] % 2 == 0) {
                chars[i]--;
                break;
            }
        }
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0 && chars[i] % 2 == 1) {
                if (chars[index] <= 0 || chars[i] < chars[index]) {
                    index = i;
                }
            }
        }
        chars[index]--;
    }

    //抽卡
    public static int getMaxMoney(int[][] cards) {
        Arrays.sort(cards, (o1, o2) -> o2[1] - o1[1]);
        return backtrack(cards, 0, 1, 0);
    }

    public static int backtrack(int[][] cards, int index, int count, int money) {
        if (count == 0) return money;
        if (index >= cards.length) return money;
        int m = cards[index][0];
        int t = cards[index][1];
        int r1 = backtrack(cards, index + 1, count - 1, m);
        int r2 = backtrack(cards, index + 1, count + t, money + m);
        return Math.max(r1, r2);
    }

    static class User {
        private int age;
        private String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main() {
        User user1 = new User(20, "Tom");
        User user2 = new User(19, "Jerry");
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user1);
        atomicReference.compareAndSet(user1, user2);

        User user = atomicReference.getAndSet(user1);
    }
}

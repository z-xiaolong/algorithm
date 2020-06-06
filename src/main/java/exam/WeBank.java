package exam;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author long
 * @Date 2020/4/8 18:51
 * @Title
 * @Description //TODO
 **/

public class WeBank {


    public static void main(String[] args) {

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

package leetcode.swordOffer.difficulty;

import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/3/20 18:07
 * @Title 合并金币 (来源：牛客网)
 * @Description 链接：https://www.nowcoder.com/questionTerminal/6d3ccbc5b6ad4f12b8fe4c97eaf969e0
 * 有 N 堆金币排成一排，第 i 堆中有 C[i] 块金币。每次合并都会将相邻的两堆金币合并为一堆，
 * 成本为这两堆金币块数之和。经过N-1次合并，最终将所有金币合并为一堆。
 * 请找出将金币合并为一堆的最低成本。
 * 其中，1 <= N <= 30，1 <= C[i] <= 100
 **/

public class MergeGold {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        String[] strings = str.trim().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = getMin(nums, dp, j, j + i);
            }
        }
        int sum = dp[0][n - 1];
        System.out.println(sum);
    }

    public static int getMin(int[] nums, int[][] dp, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (i + 1 == j) {
            return nums[i] + nums[j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, dp[i][k] + dp[k + 1][j]);
        }
        for (int k = i; k <= j; k++) {
            min += nums[k];
        }
        return min;
    }
}

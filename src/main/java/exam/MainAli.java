package exam;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/3/30 19:24
 * @Title
 * @Description //TODO
 **/

public class MainAli {


    public static void maxExpectation() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        double e = 0;
        double p = 2.0 / (((double) n + 1) * (double) n);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            dp[i] = nums[i];
            e += nums[i] * p;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j] = Math.max(dp[j], dp[j + 1]);
                e += dp[j] * p;
            }
        }
        System.out.println(String.format("%.6f", e));//四舍五入
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int max = getMax(nums, j, j + i);
                hashMap.put(max, hashMap.getOrDefault(max, 0) + 1);
            }
        }
        double sum = (n + 1) * n / 2;
        double e = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            double value = entry.getValue();
            e += key * (value / sum);
        }
        DecimalFormat df = new DecimalFormat("#.000000");
        System.out.println(df.format(e));
    }

    public static int getMax(int[] nums, int i, int j) {
        int max = 0;
        for (int k = i; k < j; k++) {
            max = Math.max(nums[k], max);
        }
        return max;
    }
}

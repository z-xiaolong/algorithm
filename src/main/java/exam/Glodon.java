package exam;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author long
 * @Date 2020/7/22 20:14
 * @Title
 * @Description //TODO
 **/

public class Glodon {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
    }


    public static void solutionIII() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int y = in.nextInt();
        int[][] animals = new int[n][2];
        for (int i = 0; i < n; i++) {
            animals[i][0] = in.nextInt();
            animals[i][1] = in.nextInt();
        }
        Arrays.sort(animals, Comparator.comparingInt(o -> o[0]));
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (animals[i][1] <= 0) continue;
            int x = animals[i][0];
            int s = x + y * 2;
            count += animals[i][1];
            int j = i + 1;
            while (j < n && animals[j][0] <= s) {
                animals[j][1] -= animals[i][1];
                j++;
            }
        }
        System.out.println(count);
    }

    public static void solutionII() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        int[] nums = new int[n];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            dp[nums[i]]++;
        }
        int j = n;
        while (dp[j] == 0) j--;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] != j) count++;
            else {
                dp[j]--;
                while (dp[j] == 0) j--;
            }
        }
        System.out.println(count);
    }


    public void solutionI() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = in.nextInt();
        }
        Arrays.sort(dp);
        int i = n - 1;
        while (i > 0 && dp[i] != dp[i - 1]) {
            i--;
        }
        long one = dp[i];
        int j = i - 2;
        while (j > 0 && dp[j] != dp[j - 1]) {
            j--;
        }
        if (j <= 0) System.out.println("-1");
        else {
            long two = dp[j];
            System.out.println(one * two);
        }
    }


}

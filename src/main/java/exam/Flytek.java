package exam;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/7/31 12:02
 * @Title 科大讯飞
 * @Description:
 */
public class Flytek {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            System.out.println(in.nextInt());
            return;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        sort(nums, 0, n - 1);
    }


    public static String toNumber(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        boolean flag = false;
        while (i < n) {
            char c = s.charAt(i++);
            if ((c == '-' && !flag) || (c >= '0' && c <= '9')) {
                if (!flag && c == '0') continue;
                builder.append(c);
                flag = true;
            }
        }
        return builder.toString();
    }



    public static int solution(int[] x1, int[] y1, int[] x2, int[] y2) {
        if (x1[0] == x2[0] && x1[1] == x2[1] && y1[0] == y2[0] && y1[1] == y2[1]) {
            return 1;
        }
        if ((x2[0] > x1[0] && x2[0] < y1[0]) || (x2[0] < x1[0] && x2[0] > y1[0])) {
            return 1;
        }
        if ((x2[1] > x1[1] && x2[1] < y1[1]) || (x2[1] < x1[1] && x2[1] > y1[1])) {
            return 1;
        }
        if ((y2[0] > x1[0] && y2[0] < y1[0]) || (y2[0] < x1[0] && y2[0] > y1[0])) {
            return 1;
        }
        if ((y2[1] > x1[1] && y2[1] < y1[1]) || (y2[1] < x1[1] && y2[1] > y1[1])) {
            return 1;
        }
        return 0;
    }


    public static void solutionII() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            System.out.println(in.nextInt());
            return;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        sort(nums, 0, n - 1);
    }


    public static void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = partition(nums, left, right);
        print(nums);
        sort(nums, left, mid - 1);
        sort(nums, mid + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int flag = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= flag) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= flag) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = flag;
        return left;
    }


    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    @Test
    public void solution() {
        Scanner in = new Scanner(System.in);
        long[][] coins = new long[5][2];
        coins[0] = new long[]{1, in.nextLong()};
        coins[1] = new long[]{5, in.nextLong()};
        coins[2] = new long[]{10, in.nextLong()};
        coins[3] = new long[]{50, in.nextLong()};
        coins[4] = new long[]{100, in.nextLong()};
        long k = in.nextLong();
        System.out.println(minCost(coins, k));
    }

    public static long minCost(long[][] coins, long k) {
        long count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (coins[i][0] <= k && coins[i][1] > 0) {
                k -= coins[i][0];
                coins[i][1]--;
                count++;
            }
        }
        if (k != 0) return -1;
        return count;
    }
}




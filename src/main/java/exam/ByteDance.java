package exam;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author long
 * @Date 2021/3/25 16:02
 * @Title
 * @Description //TODO
 **/

public class ByteDance {

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] q = new int[n + 1];
        int head = 0;
        int tail = -1;
        for (int i = 0; i < n; i++) {
            while (head <= tail && q[head] <= i - k) {
                head++;
            }
            while (head <= tail && nums[q[tail]] < nums[i]) {
                tail--;
            }
            q[++tail] = i;
            if (i - k >= -1) {
                System.out.println(nums[q[head]]);
            }
        }
    }


    //单调队列
    public static void cake() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] sum = new int[N + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + in.nextInt();
        }
        int[] q = new int[N + 1];
        int head = 0;
        int tail = 0;
        for (int i = 1; i <= N; i++) {
            while (head <= tail && q[head] < i - M) {
                head++;
            }
            ans = Math.max(ans, sum[i] - sum[q[head]]);
            while (head <= tail && sum[q[tail]] > sum[i]) {
                tail--;
            }
            q[++tail] = i;
        }
        System.out.println(ans);
    }

    public int[] missingTwo(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        Stack<Integer> stack1 = new Stack<>();

        int n = nums.length;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n + 2; i++) {
            xor ^= i;
        }
        int bit = 1;
        while ((xor & bit) == 0) {
            bit <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        for (int i = 1; i <= n + 2; i++) {
            if ((i & bit) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }

}

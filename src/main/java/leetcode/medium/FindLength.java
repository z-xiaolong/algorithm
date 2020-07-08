package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/7/1 10:00
 * @Title
 * @Description //TODO
 **/

public class FindLength {


    //二分+Hash
    public int findLength(int[] A, int[] B) {
        return 0;
    }


    //DP+Hash：执行用时：197 ms, 在所有 Java 提交中击败了7.21%的用户
    public int findLengthIII(int[] A, int[] B) {
        MList[] mList = new MList[100];
        for (int i = 0; i < A.length; i++) {
            if (mList[A[i]] == null) mList[A[i]] = new MList();
            mList[A[i]].add(i + 1);
        }
        int max = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= B.length; i++) {
            if (mList[B[i-1]] == null) continue;
            int n = mList[B[i-1]].top;
            int[] nums = mList[B[i]].nums;
            for (int j = 0; j < n; j++) {
                dp[nums[j]][i] = dp[nums[j] - 1][i - 1] + 1;
                max = Math.max(max, dp[nums[j]][i]);
            }
        }
        return max;
    }

    static class MList {
        int[] nums = new int[16];
        int top;

        public void add(int num) {
            if (top == nums.length) {
                grow();
            }
            nums[top] = num;
            top++;
        }

        private void grow() {
            int oldSize = nums.length;
            int newSize = oldSize + oldSize << 1;
            nums = Arrays.copyOf(nums, newSize);
        }
    }


    //DP O(n^2): 执行用时：86 ms, 在所有 Java 提交中击败了14.73%的用户
    public int findLengthII(int[] A, int[] B) {
        int a = A.length;
        int b = A.length;
        int max = 0;
        int[][] dp = new int[a + 1][b + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }


    //暴力法O(n^3): 执行用时：2490 ms, 在所有 Java 提交中击败了5.04%的用户
    public int findLengthI(int[] A, int[] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int a = i;
                int b = j;
                while (a < A.length && b < B.length && A[a] == B[b]) {
                    a++;
                    b++;
                }
                max = Math.max(max, a - i);
            }
        }
        return max;
    }
}

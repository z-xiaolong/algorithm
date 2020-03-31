package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/3/22 9:42
 * @Title 945. 使数组唯一的最小增量
 * @Description //TODO
 **/

public class MinIncrementForUnique {

    //基数排序：执行用时 :6 ms, 在所有 Java 提交中击败了95.92%的用户
    public int minIncrementForUnique(int[] A) {
        int n = 80000;  //最坏情况
        int count = 0;
        int[] arr = new int[n];
        for (int a : A) {
            arr[a]++;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > 1) {
                arr[i + 1] += arr[i] - 1;
                count += arr[i] - 1;
            }
        }
        return count;
    }

    //排序：执行用时 :16 ms, 在所有 Java 提交中击败了77.43%的用户
    public int minIncrementForUniqueI(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] <= 0) {
                count += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        return count;
    }
}

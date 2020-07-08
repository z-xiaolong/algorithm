package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2020/7/2 10:08
 * @Title 378. 有序矩阵中第K小的元素
 * @Description //TODO
 **/

public class KthSmallest {


    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];
        while (min < max) {
            int mid = (max + min) >> 1;
            int small = binarySearch(matrix, mid);
            if (small >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        int mid = binarySearch(matrix, max);
        if (k == mid) return max;
        else if (k > mid) return max - 1;
        return max + 1;
    }

    public int binarySearch(int[][] matrix, int target) {
        int sum = 0;
        int n = matrix.length;
        int r = n - 1;
        int c = 0;
        while (r >= 0 && c < n) {
            while (r >= 0 && matrix[c][r] > target) {
                r--;
            }
            sum += r;
            c++;
        }
        return sum;
    }


    //优先队列O(n^2)：执行用时：25 ms, 在所有 Java 提交中击败了21.07%的用户
    public int kthSmallestI(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queue.add(matrix[i][j]);
                if (queue.size() > k) queue.poll();
            }
        }
        return queue.poll();
    }
}

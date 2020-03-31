package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/3 12:47
 * @Title 面试题 10.01. 合并排序的数组
 * @Description 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 **/

public class Merge {
    public void merge(int[] A, int m, int[] B, int n) {
        if (m == 0) {
            if (n >= 0) System.arraycopy(B, 0, A, 0, n);
        }
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] <= B[j]) {
                A[index] = B[j];
                j--;
            } else {
                A[index] = A[i];
                i--;
            }
            index++;
        }
        while (j >= 0 && index >= 0) {
            A[index] = B[j];
            j--;
            index--;
        }
    }
}

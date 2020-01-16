package algorithm.chapter8;

/**
 * @Author long
 * @Date 2019/10/13 20:54
 * @Description  计数排序，时间复杂度：O(n)
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 3, 3, 7, 3, 5, 6, 6, 7, 7, 2, 2, 2, 4, 4, 4, 8, 8, 8, 9, 9, 9};
        int[] b = countingSort(array, 10);
        for (int i : b) {
            System.out.print(i + " ");
        }
    }

    public static int[] countingSort(int[] A, int k) {
        int[] B = new int[A.length];
        int[] C = new int[k];
        for (int i = 0; i < A.length; i++) {
            C[A[i]] = C[A[i]] + 1;
        }

        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i]] - 1] = A[i];
            C[A[i]] = C[A[i]] - 1;
        }
        return B;
    }
}

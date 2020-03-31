package leetcode.swordOffer.easy;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/3/8 10:14
 * @Title 面试题40. 最小的k个数
 * @Description 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 **/

public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 1};
        getLeastNumbers(nums, 4);
    }

    //堆  执行用时 :5 ms, 在所有 Java 提交中击败了81.66%的用户
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        buildHeap(arr, k);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                arr[0] = arr[i];
                heapify(arr, k, 0);
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    //构造最大堆
    public static void heapify(int[] arr, int size, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int maxIndex = index;
        if (left < size && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < size && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[index];
            arr[index] = temp;
            heapify(arr, size, maxIndex); //******很重要******///
        }

    }

    public static void buildHeap(int[] arr, int size) {
        for (int i = size / 2; i >= 0; i--) {
            heapify(arr, size, i);
        }
    }

    //分治  执行用时 :4 ms, 在所有 Java 提交中击败了87.52%的用户
    public static int[] getLeastNumbersII(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] res = new int[k];
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (mid != k - 1) {
            mid = divide(arr, left, right);
            if (mid > k - 1) {
                right = mid - 1;
            } else if (mid < k - 1) {
                left = mid + 1;
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static int divide(int[] arr, int left, int right) {
        if (left >= right) {
            return left;
        }
        int k = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= k) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= k) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = k;
        return left;
    }

    //排序暴力解 ：执行用时 :8 ms, 在所有 Java 提交中击败了69.11%的用户
    public int[] getLeastNumbersI(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}

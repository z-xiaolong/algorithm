package algorithm.chapter8;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2019/10/13 21:31
 * @Description 基数排序，空间换时间
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 8, 9, 2, 1, 5, 7, 8, 9, 100000};
        array = radixSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static int[] radixSort(int[] nums) {

        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
        int[] bucket = new int[n];
        int max = Arrays.stream(nums).max().getAsInt();
        int exp = 1;
        while (max >= exp) {
            int[] radix = new int[10];
            for (int num : nums) {
                int index = (num / exp) % 10;
                radix[index]++;
            }
            for (int i = 1; i < radix.length; i++) {
                radix[i] += radix[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int index = (nums[i] / exp) % 10;
                bucket[radix[index] - 1] = nums[i];
                radix[index]--;
            }
            int[] temp = nums;
            nums = bucket;
            bucket = temp;
            exp *= 10;
        }
        return nums;
    }

    //d表示最大的数有多少位
    public static void sort(int[] number, int d) {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组order[i]用来表示该位是i的数的个数
        while (m <= d) {
            for (int value : number) {
                int lsd = ((value / n) % 10);
                temp[lsd][order[lsd]] = value;
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
}

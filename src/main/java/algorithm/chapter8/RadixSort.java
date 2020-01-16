package algorithm.chapter8;

/**
 * @Author long
 * @Date 2019/10/13 21:31
 * @Description 基数排序，空间换时间
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 8, 9, 2, 1, 5, 7, 8, 9};
        sort(array, 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    //d表示最大的数有多少位
    public static void sort(int[] number, int d) {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while (m <= d) {
            for (int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0)
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
}

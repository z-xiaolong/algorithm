package algorithm.chapter7;

/**
 * @Author long
 * @Date 2019/10/9 21:14
 * @Description 快速排序，分治
 */
public class QuickSort {
/*    public static void main(String[] args) {
        int[] array = new int[]{-6, 1, 2, 1, 2, -39, 1, 4, 0, 8, 5, 8, 2};
        //Arrays.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        quickSortTwo(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }*/


    public static void quickSort(int[] array, int head, int tail) {
        if (head < tail) {
            int q = partition(array, head, tail);
            quickSort(array, head, q - 1);
            quickSort(array, q + 1, tail);
        }
    }

    public static void quickSortTwo(int[] array, int head, int tail) {
        if (head < tail) {
            int q = partitionTwo(array, head, tail);
            quickSortTwo(array, head, q - 1);
            quickSortTwo(array, q + 1, tail);
        }
    }

    public static int partition(int[] array, int head, int tail) {
        int flag = array[head];
        while (head < tail) {
            while (head < tail && array[tail] >= flag) {
                tail--;
            }
            array[head] = array[tail];
            while (head < tail && array[head] <= flag) {
                head++;
            }
            array[tail] = array[head];
        }
        array[head] = flag;
        return head;
    }

    public static int partitionTwo(int[] array, int head, int tail) {
        int flag = array[tail];
        int i = head - 1;
        for (int j = head; j <= tail - 1; j++) {
            if (array[j] <= flag) {
                i = i + 1;
                exchange(array, i, j);
            }
        }
        exchange(array, i + 1, tail);
        return i + 1;
    }

    public static void exchange(int[] array, int a, int b) {
        if (a == b)
            return;
        array[a] = array[a] + array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        partitionI(array, 0, array.length - 1);
    }

    private static int partitionI(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}

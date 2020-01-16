package algorithm.chapter6;

/**
 * @Author long
 * @Date 2019/10/5 21:05
 * @Description
 */
public class main {
    public static void main(String[] args) {
        int[] array = new int[]{27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        for (int i : array) {
            System.out.print(i + " ");
        }
        Heap heap = new Heap(array);
        heap.buildMaxHeap();
        System.out.println();
        heap.heapSort();
        heap.print();
    }
}

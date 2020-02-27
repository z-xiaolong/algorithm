package algorithm.chapter6;

import java.util.Collections;

/**
 * @Author long
 * @Date 2019/10/5 20:03
 * @Description 堆排序，时间复杂度O(nlgn)
 */
public class HeapSort {
    public static void main(String[] args) {
        /*int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
        }*/
        int[] array = new int[]{27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        buildMinHeap(array);
        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println();
        heapSortMin(array);
        System.out.println();
        heapSortMax(array);
    }

    public static void heapSortMax(int[] array) {
        buildMaxHeap(array);
        int size = array.length - 1;
        for (int i = size; i >= 1; i--) {
            array[0] = array[0] + array[i];
            array[i] = array[0] - array[i];
            array[0] = array[0] - array[i];
            size--;
            maxHeapify(array, 0, size);
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void maxHeapify(int[] array, int index, int size) {
        int largest;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left <= size && array[left] > array[index]) {
            largest = left;
        } else {
            largest = index;
        }
        if (right <= size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            array[largest] = array[largest] + array[index];
            array[index] = array[largest] - array[index];
            array[largest] = array[largest] - array[index];
            maxHeapify(array, largest, size);
        }
    }

    public static void buildMaxHeap(int[] array) {
        int size = array.length - 1;
        for (int i = size / 2; i >= 0; i--) {
            maxHeapify(array, i, size);
        }
    }

    public static void minHeapify(int[] array, int index, int size) {
        int largest;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left <= size && array[left] < array[index]) {
            largest = left;
        } else {
            largest = index;
        }
        if (right <= size && array[right] < array[largest]) {
            largest = right;
        }
        if (largest != index) {
            array[largest] = array[largest] + array[index];
            array[index] = array[largest] - array[index];
            array[largest] = array[largest] - array[index];
            minHeapify(array, largest, size);
        }
    }

    public static void buildMinHeap(int[] array) {
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeapify(array, i, size - 1);
        }
    }

    public static void heapSortMin(int[] array) {
        int size = array.length - 1;
        buildMinHeap(array);
        for (int i = size; i >= 1; i--) {
            array[size] = array[0] + array[size];
            array[0] = array[size] - array[0];
            array[size] = array[size] - array[0];
            size--;
            minHeapify(array, 0, size);
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

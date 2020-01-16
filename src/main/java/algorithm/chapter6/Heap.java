package algorithm.chapter6;

/**
 * @Author long
 * @Date 2019/10/5 20:43
 * @Description 完全二叉树
 */
public class Heap {
    public int[] heap;
    public int size;

    public Heap(int[] array) {
        this.size = array.length;
        this.heap = new int[array.length + 1];
        for (int i = 1; i <= size; i++) {
            heap[i] = array[i - 1];
        }
    }

    public int parent(int index) {
        return index / 2;
    }

    public int left(int index) {
        return 2 * index;
    }

    public int right(int index) {
        return 2 * index + 1;
    }

    public void maxHeapify(int i) {
        int largest;
        int left = left(i);
        int right = right(i);
        if (left <= size && heap[left] > heap[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        for (int i = size / 2; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    public void exchange(int a, int b) {
        heap[a] = heap[a] + heap[b];
        heap[b] = heap[a] - heap[b];
        heap[a] = heap[a] - heap[b];
    }

    public void print(){
        for (int i : heap) {
            System.out.print(i + " ");
        }
    }

    public void heapSort(){
        buildMaxHeap();
        for (int i = size; i >= 2; i--){
            exchange(1,i);
            size--;
            maxHeapify(1);
        }
    }

}

package algorithm.chapter6;

/**
 * @Author long
 * @Date 2019/10/6 11:07
 * @Description 最大优先队列
 */
public class MaxPriorityQueue {
    private int[] queue = new int[16];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(int key) {
        int length = queue.length;
        if (size >= length) {
            int[] newQueue = new int[length * 2];
            for (int i = 0; i < length; i++) {
                newQueue[i] = queue[i];
            }
            queue = newQueue;
        }
        queue[size] = Integer.MIN_VALUE;
        increaseKey(key, size);
        size++;
    }

    public int maximum() {
        return queue[0];
    }

    public int extractMax() {
        if (size < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int max = queue[0];
        queue[0] = queue[size - 1];
        queue[size - 1] = 0;
        size--;
        maxHeapify(0);
        return max;
    }

    public void increaseKey(int key, int index) {
        if (key < queue[index]) {
            return;
        }
        queue[index] = key;
        while (index > 0 && queue[parent(index)] < queue[index]) {
            exchange(parent(index), index);
            index = parent(index);
        }
    }

    private void exchange(int a, int b) {
        queue[a] = queue[a] + queue[b];
        queue[b] = queue[a] - queue[b];
        queue[a] = queue[a] - queue[b];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    private void maxHeapify(int index) {
        int largest;
        int left = left(index);
        int right = right(index);
        if (left <= size - 1 && queue[left] > queue[index]) {
            largest = left;
        } else {
            largest = index;
        }
        if (right <= size - 1 && queue[right] > queue[largest]) {
            largest = right;
        }
        if (largest != index) {
            queue[largest] = queue[largest] + queue[index];
            queue[index] = queue[largest] - queue[index];
            queue[largest] = queue[largest] - queue[index];
            maxHeapify(largest);
        }
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public void sort(){
        System.out.println();
        while (size > 0){
            System.out.print(extractMax()+" ");
        }
        System.out.println();
    }
}

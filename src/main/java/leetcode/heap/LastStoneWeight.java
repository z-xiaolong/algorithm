package leetcode.heap;

/**
 * @Author long
 * @Date 2019/10/7 16:56
 * @Description 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        LastStoneWeight last = new LastStoneWeight();
        last.buildHeap(stones, stones.length);
        for (int i : stones) {
            System.out.print(i+" ");
        }
    }

    public int lastStoneWeight(int[] stones) {
        int size = stones.length;
        buildHeap(stones, size);
        for (int i = size; i > 1; i--) {
            int max = extractMax(stones, i);
            if (max != stones[0]) {
                stones[0] = max - stones[0];
                heapify(stones, 0, i - 1);
            } else {
                extractMax(stones, i - 1);
                i--;
            }
        }
        return stones[0];
    }

    public int extractMax(int[] stones, int size) {
        stones[size - 1] = stones[size - 1] + stones[0];
        stones[0] = stones[size - 1] - stones[0];
        stones[size - 1] = stones[size - 1] - stones[0];
        heapify(stones, 0, size - 1);
        return stones[size - 1];
    }

    public void heapify(int[] array, int index, int size) {
        int largest;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left <= size - 1 && array[left] > array[index]) {
            largest = left;
        } else {
            largest = index;
        }
        if (right <= size - 1 && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            array[index] = array[largest] + array[index];
            array[largest] = array[index] - array[largest];
            array[index] = array[index] - array[largest];
            heapify(array, largest, size);
        }
    }

    public void buildHeap(int[] array, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, i, size);
        }
    }
}

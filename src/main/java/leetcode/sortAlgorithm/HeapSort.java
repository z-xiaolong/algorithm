package leetcode.sortAlgorithm;

/**
 * @Author long
 * @Date 2020/3/31 9:17
 * @Title
 * @Description //TODO
 **/

public class HeapSort {

    public int[] sortArray(int[] nums) {
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            maxHeapify(nums, i, 0);
        }
        return nums;
    }

    public void maxHeapify(int[] nums, int size, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        if (left < size && nums[max] < nums[left]) {
            max = left;
        }
        if (right < size && nums[max] < nums[right]) {
            max = right;
        }
        if (max != index) {
            swap(nums, max, index);
            maxHeapify(nums, size, max);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void buildMaxHeap(int[] nums) {
        int length = nums.length;
        int mid = length / 2;
        for (int i = mid; i >= 0; i--) {
            maxHeapify(nums, length, i);
        }
    }
}

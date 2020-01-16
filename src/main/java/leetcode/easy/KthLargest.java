package leetcode.easy;

/**
 * @Author long
 * @Date 2019/10/12 20:05
 * @Description 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest类需要一个同时接收整数k和整数数组nums的构造器，它包含数据流中的初始元素。每次调用KthLargest.add，返回当前数据流中第K大的元素。
 */
public class KthLargest {
    private int k;
    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new int[k];
        for (int i = 0; i < k; i++) {
            this.nums[i] = Integer.MIN_VALUE;
        }
        for (int i : nums) {
            add(i);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 6, 8, 0, 2, 3, 6, 9, 10};
        System.out.println(findKthLargest(array, 7));
    }

    //在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    public static int findKthLargest(int[] nums, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            minHeapify(nums, k, i);
        }
        for (int i = k; i < nums.length; i++) {
            add(nums, k, nums[i]);
        }
        return nums[0];
    }

    public static void add(int[] nums, int k, int val) {
        if (val > nums[0]) {
            nums[0] = val;
            minHeapify(nums, k, 0);
        }
    }

    public static void minHeapify(int[] nums, int k, int index) {
        int smallest;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < k && nums[left] < nums[index]) {
            smallest = left;
        } else {
            smallest = index;
        }
        if (right < k && nums[right] < nums[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            nums[smallest] = nums[smallest] + nums[index];
            nums[index] = nums[smallest] - nums[index];
            nums[smallest] = nums[smallest] - nums[index];
            minHeapify(nums,k,smallest);
        }
    }

    public void minHeapify(int index) {
        int smallest;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < k && nums[left] < nums[index]) {
            smallest = left;
        } else {
            smallest = index;
        }
        if (right < k && nums[right] < nums[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            nums[smallest] = nums[smallest] + nums[index];
            nums[index] = nums[smallest] - nums[index];
            nums[smallest] = nums[smallest] - nums[index];
            minHeapify(smallest);
        }
    }

    public int add(int val) {
        if (val > nums[0]) {
            nums[0] = val;
            minHeapify(0);
        }
        return nums[0];
    }
}

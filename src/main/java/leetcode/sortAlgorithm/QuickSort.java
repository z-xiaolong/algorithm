package leetcode.sortAlgorithm;

/**
 * @Author long
 * @Date 2020/3/30 15:39
 * @Title 快速排序
 * @Description //TODO
 **/

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 6, 7, 434, 54, 5, 9, 0};
        quickSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            sort(nums, left, mid - 1);
            sort(nums, mid + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int k = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= k) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= k) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = k;
        return left;
    }
}

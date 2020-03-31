package leetcode.medium;

/**
 * @Author long
 * @Date 2020/3/31 8:52
 * @Title 912. 排序数组
 * @Description //TODO
 **/

public class SortArray {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        int maxIndex = getMax(nums, left, mid, right);
        swap(nums, left, maxIndex);
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public int getMax(int[] nums, int left, int mid, int right) {
        if (nums[left] >= nums[mid] && nums[left] >= nums[right]) {
            return left;
        } else if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
            return mid;
        } else {
            return right;
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
}

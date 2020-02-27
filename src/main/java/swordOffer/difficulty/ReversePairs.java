package swordOffer.difficulty;

/**
 * @Author long
 * @Date 2020/2/13 16:45
 * @Title 面试题51. 数组中的逆序对
 * @Description 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 **/

public class ReversePairs {

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = new int[]{3, 1, 2, 5, 7, 8, 0, 1,5};
        reversePairs.quickSort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private int sum = 0;

    public int reversePairs(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return sum;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = binary(nums, left, right);
        //sum += mid - left + 1;
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    public int binary(int[] nums, int left, int right) {
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


    //遍历，超时
    public int traverse(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    sum++;
                }
            }
        }
        return sum;
    }
}

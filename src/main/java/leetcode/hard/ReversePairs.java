package leetcode.hard;

/**
 * @Author long
 * @Date 2020/4/24 10:29
 * @Title 面试题51. 数组中的逆序对
 * @Description //TODO
 **/

public class ReversePairs {

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = new int[]{11, 2, 5, 7, 1, 0, 9, 7, 5, 8, 11};
        nums = reversePairs.mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    int count = 0;

    //归并排序：执行用时 :33 ms, 在所有 Java 提交中击败了91.87%的用户
    public int reversePairs(int[] nums) {
        int length = nums.length;
        if (length == 0) return count;
        mergeSort(nums, 0, length - 1);
        return count;
    }

    public int[] mergeSort(int[] nums, int left, int right) {
        if (left == right) return new int[]{nums[left]};
        int mid = (left + right) / 2;
        int[] leftArray = mergeSort(nums, left, mid);
        int[] rightArray = mergeSort(nums, mid + 1, right);
        return merge(leftArray, rightArray);
    }

    public int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int index = 0;
        int[] newArray = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                newArray[index++] = left[i++];
            } else {
                count += (left.length - i);
                newArray[index++] = right[j++];
            }
        }
        while (i < left.length) {
            newArray[index++] = left[i++];
        }
        while (j < right.length) {
            newArray[index++] = right[j++];
        }
        return newArray;
    }
}

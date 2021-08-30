package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author long
 * @Date 2021/3/13 14:19
 * @Title 排序算法
 * @Description //TODO
 **/

public class Sort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 9, 1, 4, 9, 10, 34, 0, 5, 22};
        int[] radixSort = radixSort(nums);
        int[] mergeSort = mergeSort(nums, 0, nums.length - 1);
        //quickSort(nums, 0, nums.length - 1);
        bucketSort(nums);
        for (int num : radixSort) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : mergeSort) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void bucketSort(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int bucketCapacity = (max - min) / nums.length;
        int bucketNum = (max - min) / bucketCapacity + 1;
        List<Integer>[] buckets = new List[bucketNum];
        for (int num : nums) {
            int index = (num - min) / bucketCapacity;
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(num);
        }
        int j = 0;
        for (List<Integer> bucket : buckets) {
            if (bucket != null) {
                Collections.sort(bucket);
                for (int num : bucket) {
                    nums[j++] = num;
                }
            }
        }
    }


    //shell 排序
    public static void shellSort(int[] nums) {

    }

    //基数排序
    public static int[] radixSort(int[] nums) {
        int len = nums.length;
        int exp = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] bucket = new int[nums.length];
        while (max >= exp) {
            int[] count = new int[10];
            for (int num : nums) {
                int index = (num / exp) % 10;
                count[index]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = len - 1; i >= 0; i--) {
                int index = (nums[i] / exp) % 10;
                bucket[count[index] - 1] = nums[i];
                count[index]--;
            }
            int[] tmp = nums;
            nums = bucket;
            bucket = tmp;
            exp *= 10;
        }
        return nums;
    }

    public static int[] mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return new int[]{nums[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftNums = mergeSort(nums, left, mid);
        int[] rightNums = mergeSort(nums, mid + 1, right);
        int[] newNums = new int[leftNums.length + rightNums.length];
        int i = 0, j = 0;
        while (i < leftNums.length && j < rightNums.length) {
            newNums[i + j] = leftNums[i] <= rightNums[j] ? leftNums[i++] : rightNums[j++];
        }
        while (i < leftNums.length) {
            newNums[i + j] = leftNums[i++];
        }
        while (j < rightNums.length) {
            newNums[i + j] = rightNums[j++];
        }
        return newNums;
    }


    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
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
}

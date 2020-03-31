package leetcode.sortAlgorithm;

/**
 * @Author long
 * @Date 2020/3/30 11:04
 * @Title 归并排序
 * @Description //TODO
 **/

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 2, 5, 2, 2, 3, 4};
        nums = mergeSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeSort(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }

    public static int[] partition(int[] nums, int left, int right) {
        if (left == right) {
            return new int[]{nums[left]};
        }
        int mid = (left + right) / 2;
        int[] leftPartition = partition(nums, left, mid);
        int[] rightPartition = partition(nums, mid + 1, right);
        return merge(leftPartition, rightPartition);
    }

    public static int[] merge(int[] a, int[] b) {
        int n = a.length - 1;
        int m = b.length - 1;
        int[] res = new int[n + m + 2];
        int i = res.length - 1;
        while (n >= 0 && m >= 0) {
            res[i--] = a[n] > b[m] ? a[n--] : b[m--];
        }
        while (n >= 0) {
            res[i--] = a[n--];
        }
        while (m >= 0) {
            res[i--] = b[m--];
        }
        return res;
    }

    public static void mergeI(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        int i = right;
        while (i > left) {
            if (nums[mid] < nums[right]) {
                swap(nums, right, i);
                if (right - 1 == mid) {
                    right = i - 1;
                } else {
                    right--;
                }
            } else {
                swap(nums, mid, i);
                if (i == right) {
                    right = mid;
                }
                mid--;
            }
            i--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //88. 合并两个有序数组：执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        while (n > 0) {
            if (m <= 0 || nums1[m - 1] <= nums2[n - 1]) {
                nums1[k - 1] = nums2[n - 1];
                n--;
            } else {
                nums1[k - 1] = nums1[m - 1];
                m--;
            }
            k--;
        }
    }
}

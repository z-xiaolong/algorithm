package leetcode.swordOffer.difficulty;

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
        int[] nums = new int[]{3, 1, 2, 5, 7, 8, 0, 1, 5};
        //nums = reversePairs.mergeSort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.print(i + " ");
        }

        nums = new int[]{7, 5, 6, 4};
        reversePairs.reversePairs(new int[0]);
    }


    //归并排序思想: 执行用时 :37 ms, 在所有 Java 提交中击败了72.62%的用户

    int count = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public int[] mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return new int[]{nums[left]};
        }
        int mid = (left + right) / 2;
        int[] leftNum = mergeSort(nums, left, mid);
        int[] rightNum = mergeSort(nums, mid + 1, right);
        return merge(leftNum, rightNum);
    }

    public int[] merge(int[] A, int[] B) {
        int[] newNum = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) {
                count += A.length - i;
                newNum[k++] = B[j++];
            } else {
                newNum[k++] = A[i++];
            }
        }
        while (i < A.length) {
            newNum[k++] = A[i++];
        }
        while (j < B.length) {
            newNum[k++] = B[j++];
        }
        return newNum;
    }


    //////////////////////////////////////////////////////////////////////////////
    private int sum = 0;

    public int reversePairsI(int[] nums) {
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

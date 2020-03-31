package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2020/3/20 9:09
 * @Title 面试题40. 最小的k个数
 * @Description //TODO
 **/

public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5, 6, 7, 1};
        GetLeastNumbers numbers = new GetLeastNumbers();
        numbers.getLeastNumbers(nums, 3);
    }

    //快排思想：执行用时 :3 ms, 在所有 Java 提交中击败了92.37%的用户
    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        if (length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = -1;
        while (mid != k) {
            mid = quickSort(arr, left, right);
            if (mid > k) {
                right = mid - 1;
            } else if (mid < k) {
                left = mid + 1;
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    public int quickSort(int[] nums, int left, int right) {
        if (left >= right) {
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

    //优先队列，时间复杂度O(nlogk)：执行用时 :35 ms, 在所有 Java 提交中击败了16.72%的用户
    public int[] getLeastNumbersI(int[] arr, int k) {
        int length = arr.length;
        if (length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int num : arr) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }
}

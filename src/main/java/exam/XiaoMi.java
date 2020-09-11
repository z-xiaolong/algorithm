package exam;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: long
 * @Date: 2020/8/21 16:07
 * @Title
 * @Description:
 */
public class XiaoMi {


    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 1, 4, 5};
        System.out.println(getNum(nums, 2));
        String s = "";

    }


    public static int getNum(int[] nums, int target) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1]);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> nums[o1] - nums[o2]);
        int left = 0;
        int right = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (; right < nums.length; right++) {
            maxQueue.add(right);
            minQueue.add(right);
            max = Math.max(max, nums[right]);
            min = Math.min(min, nums[right]);
            while (max - min > target && left < right) {
                count += right - left;
                while (maxQueue.peek() <= left) {
                    maxQueue.poll();
                }
                max = nums[maxQueue.peek()];
                while (minQueue.peek() <= left) {
                    minQueue.poll();
                }
                min = nums[minQueue.peek()];
                left++;
            }
        }
        int size = right - left;
        count += (size + 1) * size / 2;
        return count;
    }


    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}

package leetcode.easy;

/**
 * @Author long
 * @Date 2019/10/13 16:38
 * @Description 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 4, 5, 5, 6};
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(array, 4));
    }

    //快排思想
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestSub(nums, k, 0, nums.length - 1);
    }

    public int findKthLargestSub(int[] nums, int k, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = partition(nums, left, right);
        if (mid - left == k - 1) {
            return nums[mid];
        } else if (mid - left < k - 1) {
            return findKthLargestSub(nums, k - 1 - mid + left, mid + 1, right);
        } else {
            return findKthLargestSub(nums, k, left, mid - 1);
        }
    }


    public int partition(int[] array, int head, int tail) {
        if (head == tail) {
            return head;
        }
        int flag = array[head];
        while (head < tail) {
            while (head < tail && array[tail] <= flag) {
                tail--;
            }
            array[head] = array[tail];
            while (head < tail && array[head] >= flag) {
                head++;
            }
            array[tail] = array[head];
        }
        array[head] = flag;
        return head;
    }
}

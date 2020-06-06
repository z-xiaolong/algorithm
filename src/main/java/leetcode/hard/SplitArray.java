package leetcode.hard;

/**
 * @Author long
 * @Date 2020/5/3 20:13
 * @Title 410. 分割数组的最大值
 * @Description //TODO
 **/

public class SplitArray {

    public static void main(String[] args) {
        SplitArray array = new SplitArray();
        int[] nums = new int[]{7, 2, 5, 10, 8};
        array.splitArray(nums, 2);
    }

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int right = 0;
        int left = 0;
        for (int num : nums) {
            right += num;
            left = Math.max(left, num);
        }
        if (m == 1) return right;
        if (m >= n) return left;
        while (left < right) {
            int mid = (left + right) >> 1;
            int bucket = split(nums, mid);
            if (bucket > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int split(int[] nums, int mid) {
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            if (sum + num > mid) {
                count++;
                sum = num;
            } else {
                sum += num;
            }
        }
        if (sum > 0) count++;
        return count;
    }
}

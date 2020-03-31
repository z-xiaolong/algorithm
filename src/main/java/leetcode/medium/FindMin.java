package leetcode.medium;

/**
 * @Author long
 * @Date 2020/3/10 17:03
 * @Title 153. 寻找旋转排序数组中的最小值
 * @Description //TODO
 **/

public class FindMin {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1};
        FindMin findMin = new FindMin();
        findMin.findMin(nums);
    }

    //二分法: 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int findMin(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left < right && nums[left] > nums[right]) {
            int mid = (left + right) / 2;
            if (nums[left] > nums[right]) {
                if (nums[mid] < nums[right]) {
                    right = mid;
                } else if (nums[mid] >= nums[left]) {
                    left = mid + 1;
                }
            }
        }
        return nums[left];
    }
}

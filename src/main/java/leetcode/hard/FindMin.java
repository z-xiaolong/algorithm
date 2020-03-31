package leetcode.hard;

/**
 * @Author long
 * @Date 2020/3/10 17:33
 * @Title 154. 寻找旋转排序数组中的最小值 II
 * @Description 注意数组中可能存在重复的元素。
 **/

public class FindMin {

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] nums = new int[]{3, 3, 1, 3};
        findMin.findMin(nums);
    }

    //二分法: 执行用时 :1 ms, 在所有 Java 提交中击败了75.40%的用户
    public int findMin(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left < right && nums[left] >= nums[right]) {
            int mid = (left + right) / 2;
            if (nums[left] >= nums[right]) {
                if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                    left++;
                    right--;
                } else if (nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else if (nums[mid] <= nums[right]) {
                    right = mid;
                }
            }
        }
        return nums[left];
    }
}

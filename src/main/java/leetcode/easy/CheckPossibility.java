package leetcode.easy;

/**
 * @Author long
 * @Date 2020/4/7 11:38
 * @Title 665. 非递减数列
 * @Description //TODO
 **/

public class CheckPossibility {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 2, 2};
        checkPossibility(nums);
    }

    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;
        if (nums.length <= 2) return true;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            cnt++;
            if (i >= 2 && nums[i - 2] > nums[i]) nums[i] = nums[i - 1];
        }
        return cnt <= 1;
    }

    //执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public static boolean checkPossibilityI(int[] nums) {
        int count = 0;
        int index = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                index = i;
            }
        }
        if (index < 0 || index + 1 == nums.length || index - 2 < 0) return true;
        if (nums[index + 1] < nums[index - 2]) {
            return false;
        } else if (nums[index + 1] == nums[index - 2]) {
            return nums[index] == nums[index - 2] || nums[index - 1] == nums[index + 1];
        } else {
            if (nums[index] > nums[index - 2]) return true;
            return nums[index - 1] < nums[index + 1];
        }
    }
}

package leetcode.easy;

/**
 * @Author long
 * @Date 15:58 2019/10/22
 * @Title 198. 打家劫舍
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 **/

public class Rob {

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 9, 3, 1};
        Rob rob = new Rob();
        rob.robII(array);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return robChoose(nums, 0, nums.length - 1);
    }

    //分治，递归
    public int robChoose(int[] nums, int first, int last) {
        if (first > last) {
            return 0;
        } else if (first == last) {
            return nums[first];
        } else if (first == last - 1) {
            return Math.max(nums[first], nums[last]);
        }
        int mid = (last + first) / 2;
        int choose = nums[mid] + robChoose(nums, first, mid - 2) + robChoose(nums, mid + 2, last);
        int noChoose = robChoose(nums, mid + 1, last) + robChoose(nums, first, mid - 1);
        return Math.max(choose, noChoose);
    }

    //动态规划，f(k) = max(f(k – 2) + A[k] , f(k – 1))
    public int robII(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

}

package leetcode.medium;

/**
 * @Author long
 * @Date 2020/3/9 10:50
 * @Title
 * @Description //TODO
 **/

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 4, 2};
        findDuplicate(nums);
    }

    //把数组看成一个链表，有重复数，就肯定有环，使用快慢指针
    public static int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        slow = 0;
        while (nums[fast] != nums[slow]) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}

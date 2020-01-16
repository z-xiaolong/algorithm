package leetcode.medium;

/**
 * @Author long
 * @Date 14:58 2019/10/27
 * @Title 287. 寻找重复数
 * @Description 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 **/

public class DuplicateNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 4, 2};
        findDuplicate(nums);
    }

    public static int findDuplicate(int[] nums) {
        int[] array = new int[nums.length];
        for (int i : nums) {
            array[i]++;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 1) {
                return i;
            }
        }
        return 0;
    }

    //把数组nums看成链表，检查循环
    public static int findDuplicateII(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}

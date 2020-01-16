package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 20:21 2019/10/26
 * @Title 448. 找到所有数组中消失的数字
 * @Description 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 **/

public class DisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        System.out.println(findDisappearedNumbersII(nums));

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length + 1;
        int[] array = new int[length];
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            array[i]++;
        }
        for (int i = 1; i < length; i++) {
            if (array[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbersII(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            nums[index1] = nums[index1] ^ nums[index2];
            nums[index2] = nums[index1] ^ nums[index2];
            nums[index1] = nums[index1] ^ nums[index2];
        }
    }


}

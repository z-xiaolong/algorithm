package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/3/25 11:58
 * @Title
 * @Description //TODO
 **/

public class MissingTwo {


    public int[] missingTwo(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i+1 && nums[i] < len) {
                swap(nums, i, nums[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1) {
                res.add(i+1);
            }
        }
        if (res.size() < 2) {

        }
        return nums;
    }


    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

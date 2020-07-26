package leetcode.easy;

/**
 * @Author long
 * @Date 2020/7/20 10:59
 * @Title
 * @Description //TODO
 **/

public class FindMagicIndex {

    public int findMagicIndex(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == index) return index;
            if (nums[index] > index)
                index = nums[index];
            else index++;
        }
        return -1;
    }
}

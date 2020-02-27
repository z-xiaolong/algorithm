package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/22 18:36
 * @Title 面试题 17.04. 消失的数字
 * @Description 数组nums包含从0到n的所有整数，但其中缺了一个。
 * 请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 **/

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int[] array = new int[length + 1];
        for (int num : nums) {
            array[num]++;
        }
        for (int i = 0; i <= length; i++) {
            if (array[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    //异或操作
    public int missingNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;
        return res;
    }
}

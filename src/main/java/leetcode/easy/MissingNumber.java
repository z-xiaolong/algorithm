package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/22 18:36
 * @Title 面试题 17.04. 消失的数字
 * @Description 数组nums包含从0到n的所有整数，但其中缺了一个。
 * 请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 **/

public class MissingNumber {

    //内存O(n) , 执行用时 :1 ms, 在所有 Java 提交中击败了82.46%的用户
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

    //异或操作  执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
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

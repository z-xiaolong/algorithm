package leetcode.medium;

/**
 * @Author long
 * @Date 2020/4/17 11:14
 * @Title 238. 除自身以外数组的乘积
 * @Description //TODO
 **/

public class ProductExceptSelf {

    //执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        int product = 1;
        for (int i = 0; i < length; i++) {
            result[i] = result[i] * product;
            product *= nums[i];
        }
        return result;
    }

    //执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public int[] productExceptSelfI(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        L[0] = 1;
        R[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = L[i] * R[i];
        }
        return nums;
    }
}

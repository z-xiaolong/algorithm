package leetcode.easy.dp;

/**
 * @Author long
 * @Date 2020/2/16 16:56
 * @Title 303. 区域和检索 - 数组不可变
 * @Description 给定一个整数数组  nums，
 * 求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 **/

public class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        int length = nums.length;
        sum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    //动态规划
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    //超出内存限制
/*    private void setSum() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    sum[i][j] = nums[i];
                } else {
                    sum[i][j] = sum[i][j - 1] + nums[j];
                }
            }
        }
    }*/


/*    //遍历，超时
    public int sumRange1(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum = nums[i] + sum;
        }
        return sum;
    }*/
}

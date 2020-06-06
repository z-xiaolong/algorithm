package leetcode.medium.dp;

/**
 * @Author long
 * @Date 2020/4/11 11:32
 * @Title
 * @Description //TODO
 **/

public class MaxProduct {

    //执行用时 :2 ms, 在所有 Java 提交中击败了92.36%的用户
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int max = Integer.MIN_VALUE;
        int subMax = nums[0];
        int subMin = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                subMax = Math.max(subMax * nums[i], nums[i]);
                subMin = Math.min(subMin * nums[i], nums[i]);
                max = Math.max(max, subMax);
            } else if (nums[i] < 0) {
                int temp = subMax;
                subMax = Math.max(subMin * nums[i], nums[i]);
                subMin = Math.min(temp * nums[i], nums[i]);
                max = Math.max(max, subMax);
            } else {
                subMax = 0;
                subMin = 0;
            }
        }
        max = Math.max(max, subMax);
        return max;
    }

    //两个dp数组：执行用时 :2 ms, 在所有 Java 提交中击败了92.36%的用户
    public int maxProductII(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                dpMax[i] = Math.max(dpMax[i - 1] * nums[i], nums[i]);
                dpMin[i] = Math.min(dpMin[i - 1] * nums[i], nums[i]);
            } else if (nums[i] < 0) {
                dpMax[i] = Math.max(dpMin[i - 1] * nums[i], nums[i]);
                dpMin[i] = Math.min(dpMax[i - 1] * nums[i], nums[i]);
            } else {
                dpMax[i] = 0;
                dpMin[i] = 0;
            }
        }
        int res = Integer.MIN_VALUE;
        for (int max : dpMax) {
            res = Math.max(res, max);
        }
        return res;
    }

    //超出内存限制
    public int maxProductI(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            max = Math.max(max, nums[i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = dp[j][j + i - 1] * nums[j + i];
                max = Math.max(max, dp[j][j + i]);
            }
        }
        return max;
    }
}

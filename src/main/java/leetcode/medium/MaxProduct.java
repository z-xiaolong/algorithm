package leetcode.medium;

/**
 * @Author long
 * @Date 2020/5/18 8:55
 * @Title 152. 乘积最大子数组
 * @Description //TODO
 **/

public class MaxProduct {

    public int maxProduct(int[] nums) {
        int positive = 1;
        int negative = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > 0) {
                positive *= num;
                if (negative < 0) negative *= num;
                res = Math.max(res, positive);
                continue;
            } else if (num < 0) {
                int temp = negative;
                negative = positive * num;
                if (temp < 0) {
                    positive = temp * num;
                    res = Math.max(res, positive);
                    continue;
                } else positive = 1;
            } else {
                positive = 1;
                negative = 1;
            }
            res = Math.max(res, num);
        }
        return res;
    }
}

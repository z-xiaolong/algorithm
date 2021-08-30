package leetcode.medium;

/**
 * @Author long
 * @Date 2021/2/23 20:14
 * @Title
 * @Description //TODO
 **/

public class MaxSatisfied {

    public static void main(String[] args) {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        maxSatisfied(customers, grumpy, 3);
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < n) {
            if (right - left + 1 > X) {
                sum -= grumpy[left] == 1 ? customers[left] : 0;
                left++;
            }
            sum += grumpy[right] == 1 ? customers[right] : 0;
            ans = Math.max(ans, sum);
            right++;
        }
        return ans;
    }
}

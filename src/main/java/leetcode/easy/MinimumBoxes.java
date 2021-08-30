package leetcode.easy;

/**
 * @Author long
 * @Date 2021/2/5 21:52
 * @Title
 * @Description //TODO
 **/

public class MinimumBoxes {

    public static void main(String[] args) {
        int[] nums = new int[]{9, 7, 7, 9, 7, 7, 9};
        System.out.println(maxScore(nums, 7));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        int left;
        int right;
        for (left = 0; left < k; left++) {
            sum += cardPoints[left];
        }
        int max = sum;
        left--;
        for (right = n - 1; right >= n - k; right--, left--) {
            sum += cardPoints[right] - cardPoints[left];
            max = Math.max(sum, max);
        }
        return max;
    }

    public static int minimumBoxes(int n) {
        int level = 1;
        int sum = 1;
        while (n > sum) {
            n -= sum;
            level++;
            sum += level;
        }
        int cnt = 1;
        while (n > cnt) {
            n -= cnt;
            cnt++;
        }
        return sum + cnt;
    }
}

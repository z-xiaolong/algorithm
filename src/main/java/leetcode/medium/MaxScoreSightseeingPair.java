package leetcode.medium;

/**
 * @Author long
 * @Date 2020/6/17 9:56
 * @Title 1014. 最佳观光组合
 * @Description //TODO
 **/

public class MaxScoreSightseeingPair {


    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans, A[i] - i + max);
            max = Math.max(max, A[i] + i);
        }
        return ans;
    }

    public int maxScoreSightseeingPairI(int[] A) {
        int length = A.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(left[i - 1] - 1, A[i - 1] - 1);
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1] - 1, A[i + 1] - 1);
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            int temp = Math.max(left[i], right[i]) + A[i];
            max = Math.max(max, temp);
        }
        return max;
    }
}

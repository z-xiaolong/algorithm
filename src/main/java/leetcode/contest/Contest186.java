package leetcode.contest;

import java.util.List;

/**
 * @Author long
 * @Date 2020/4/26 10:08
 * @Title
 * @Description //TODO
 **/

public class Contest186 {

    //5392. 分割字符串的最大得分
    public int maxScore(String s) {
        int score = 0;
        char[] chars = s.toCharArray();
        int zero = 0;
        int i = 0;
        while (i < chars.length - 1) {
            while (i < chars.length - 1 && chars[i] == '0') {
                zero++;
                i++;
            }
            if (i == 0) i++;
            score = Math.max(score, zero + getScore(chars, i));
            while (i < chars.length && chars[i] == '1') {
                i++;
            }
        }
        return score;
    }

    public int getScore(char[] chars, int index) {
        int score = 0;
        while (index < chars.length) {
            if (chars[index] == '1') score++;
            index++;
        }
        return score;
    }


    //5393. 可获得的最大点数

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxScore = 0;
        if (k >= n) {
            for (int point : cardPoints) {
                maxScore += point;
            }
            return maxScore;
        }
        int[] left = new int[k + 1];
        int[] right = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            left[i] = left[i - 1] + cardPoints[i - 1];
        }
        for (int i = n - 1; i >= n - k; i--) {
            right[n - i] = right[n - i - 1] + cardPoints[i];
        }
        for (int i = 0; i <= k; i++) {
            maxScore = Math.max(left[i] + right[k - i], maxScore);
        }
        return maxScore;
    }


    //5394. 对角线遍历 II
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        return null;
    }

    public static void main(String[] args) {
        Contest186 contest = new Contest186();
        int[] nums = new int[]{1, 79, 80, 1, 1, 1, 200, 1};
        contest.maxScore(nums, 3);
    }
}

package leetcode.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author long
 * @Date 2021/2/21 10:23
 * @Title
 * @Description //TODO
 **/

public class Contest229 {

    public static void main(String[] args) {

    }


    public String mergeAlternately(String word1, String word2) {
        char[] one = word1.toCharArray();
        char[] two = word2.toCharArray();
        char[] ans = new char[one.length + two.length];
        int i = 0, j = 0;
        for (; i < one.length && j < two.length; i++, j++) {
            ans[i + j] = one[i];
            ans[i + j + 1] = two[j];
        }
        while (i < one.length) {
            ans[i + j] = one[i];
            i++;
        }
        while (j < two.length) {
            ans[i + j] = two[j];
            j++;
        }
        return new String(ans);
    }

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                set.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int num : set) {
                ans[i] += Math.abs(i - num);
            }
        }
        return ans;
    }


    public int maximumScore(int[] nums, int[] multipliers) {
        int n = multipliers.length;
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

        }

        return max;
    }

}

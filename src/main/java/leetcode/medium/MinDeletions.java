package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/3/13 22:04
 * @Title
 * @Description //TODO
 **/

public class MinDeletions {

    public static void main(String[] args) {
        minDeletions("bbcebab");
    }

    public static int minDeletions(String s) {
        int[] digits = new int[26];
        for (int i = 0; i < s.length(); i++) {
            digits[s.charAt(i) - 'a']++;
        }
        int count = 0;
        Arrays.sort(digits);
        int i = 24;
        while (i >= 0) {
            if (digits[i] == 0) {
                break;
            }
            if (digits[i] >= digits[i + 1]) {
                if (digits[i + 1] == 0) {
                    count += digits[i];
                    digits[i] = 0;
                } else {
                    count += digits[i] - digits[i + 1] + 1;
                    digits[i] = digits[i + 1] - 1;
                }
            }
            i--;
        }
        return count;
    }
}

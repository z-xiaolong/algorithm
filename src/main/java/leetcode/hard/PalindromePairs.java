package leetcode.hard;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/6 9:22
 * @Title
 * @Description:
 */
public class PalindromePairs {

    public static void main(String[] args) {
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        PalindromePairs pairs = new PalindromePairs();
        pairs.palindromePairs(words);
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(words[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            if (m == 0) continue;
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(word, j, m - 1)) {
                    String reverse = reverse(word.substring(0, j));
                    int right = hashMap.getOrDefault(reverse, -1);
                    if (right != -1 && right != i) {
                        res.add(Arrays.asList(i, right));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    String reverse = reverse(word.substring(j, m));
                    int left = hashMap.getOrDefault(reverse, -1);
                    if (left != -1 && left != i) {
                        res.add(Arrays.asList(left, i));
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public String reverse(String word) {
        char[] chars = word.toCharArray();
        int n = chars.length - 1;
        if (n < 0) return "";
        for (int i = 0; i <= n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - i];
            chars[n - i] = temp;
        }
        return new String(chars);
    }
}

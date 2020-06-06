package leetcode.swordOffer.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/31 11:13
 * @Title
 * @Description //TODO
 **/

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }


    //O(n)hashMap: 执行用时 :7 ms, 在所有 Java 提交中击败了82.96%的用户
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) return length;
        int i = 0;
        int j = 0;
        int max = 1;
        Map<Character, Integer> hashMap = new HashMap<>();
        while (j < length) {
            char c = s.charAt(j);
            if (hashMap.containsKey(c)) {
                i = Math.max(hashMap.get(c) + 1, i);
            }
            max = Math.max(max, j - i + 1);
            hashMap.put(c, j);
            j++;
        }
        return max;
    }

    //O(n^2)
    public static int lengthOfLongestSubstringI(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int i = 0;
        int j = 1;
        int max = 0;
        while (j < length) {
            for (int k = i; k < j; k++) {
                if (s.charAt(j) == s.charAt(k)) {
                    i = k + 1;
                    break;
                }
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}

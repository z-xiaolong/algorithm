package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/5/2 7:40
 * @Title 3. 无重复字符的最长子串
 * @Description //TODO
 **/

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) return 0;
        Set<Character> set = new HashSet<>();
        int longest = 0;
        int left = 0;
        int right = 0;
        while (right < length) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                longest = Math.max(longest, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return longest;
    }
}

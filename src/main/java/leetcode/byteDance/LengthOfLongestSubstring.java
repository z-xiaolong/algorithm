package leetcode.byteDance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/6/17 10:37
 * @Title 无重复字符的最长子串
 * @Description //TODO
 **/

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) return length;
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int left = -1;
        int right;
        for (right = 0; right < length; right++) {
            char c = s.charAt(right);
            if (map.getOrDefault(c, -1) <= left) {
                max = Math.max(max, right - left);
            } else {
                left = map.get(c);
            }
            map.put(c, right);
        }
        return max;
    }
}

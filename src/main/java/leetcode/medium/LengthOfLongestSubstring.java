package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author long
 * @Date 14:20 2019/11/10
 * @Title 3. 无重复字符的最长子串
 * @Description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 **/

public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int index = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                index = Math.max(hashMap.get(c), i);
            }
            length = Math.max(length, i - index + 1);
            hashMap.put(c, i + 1);
            //TODO
        }
        return length;
    }

    //滑动窗口
    public int lengthOfLongestSubstring_two(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        //利用 i < n && j < n 实现找到重复字符
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //利用 HashMap 找到重复字符
    public int lengthOfLongestSubstring_HashMap(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

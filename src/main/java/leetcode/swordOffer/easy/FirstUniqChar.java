package leetcode.swordOffer.easy;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/11 19:57
 * @Title 面试题50. 第一个只出现一次的字符
 * @Description 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 **/

public class FirstUniqChar {


    //Set特新：执行用时 :29 ms, 在所有 Java 提交中击败了46.93%的用户
    public char firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();
        Set<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                hashSet.add(c);
            } else {
                hashSet.remove(c);
            }
        }
        if (hashSet.isEmpty()) {
            return ' ';
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashSet.contains(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    //利用HashMap： 执行用时 :35 ms, 在所有 Java 提交中击败了40.78%的用户
    public char firstUniqCharI(String s) {
        Map<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = hashMap.getOrDefault(c, 0);
            hashMap.put(c, count + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}

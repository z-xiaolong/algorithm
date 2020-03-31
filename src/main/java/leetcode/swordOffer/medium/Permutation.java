package leetcode.swordOffer.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/24 23:03
 * @Title 面试题38. 字符串的排列
 * @Description //TODO
 **/

public class Permutation {

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'c'};
        System.out.println(String.valueOf(chars));
    }


    //交换法: 执行用时 :25 ms, 在所有 Java 提交中击败了70.13%的用户
    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        backtrack(set, chars, 0);
        return set.toArray(new String[0]);
    }

    public void backtrack(Set<String> set, char[] chars, int index) {
        if (index == chars.length) {
            set.add(String.valueOf(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            backtrack(set, chars, index + 1);
            swap(chars, index, i);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    //手动去重：执行用时 :48 ms, 在所有 Java 提交中击败了46.56%的用户
    public String[] permutationII(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        List<String> list = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(hashMap, list, builder, s, 0);
        return list.toArray(new String[0]);
    }

    public void backtrack(Map<Character, Integer> hashMap, List<String> list, StringBuilder stringBuilder, String s, int index) {
        if (index == s.length()) {
            list.add(stringBuilder.toString());
            return;
        }
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (entry.getValue() > 0) {
                hashMap.put(key, value - 1);
                stringBuilder.append(key);
                backtrack(hashMap, list, stringBuilder, s, index + 1);
                hashMap.put(key, value);
                stringBuilder.deleteCharAt(index);
            }
        }
    }

    //利用set去重：执行用时 :42 ms, 在所有 Java 提交中击败了52.64%的用户
    public String[] permutationI(String s) {
        int[] flag = new int[s.length()];
        Set<String> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtrackI(flag, set, stringBuilder, s, 0);
        return set.toArray(new String[0]);
    }

    public void backtrackI(int[] flag, Set<String> set, StringBuilder builder, String s, int index) {
        if (index == s.length()) {
            set.add(builder.toString());
            return;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                builder.append(s.charAt(i));
                backtrackI(flag, set, builder, s, index + 1);
                builder.deleteCharAt(index);
                flag[i] = 0;
            }
        }
    }
}

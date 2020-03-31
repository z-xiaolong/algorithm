package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/28 10:27
 * @Title 820. 单词的压缩编码
 * @Description 每个单词都是小写字母
 **/

public class MinimumLengthEncoding {


    public static void main(String[] args) {
        MinimumLengthEncoding encoding = new MinimumLengthEncoding();
        String[] words = new String[]{"time", "me", "bell"};
        encoding.minimumLengthEncoding(words);
    }

    //字典树：执行用时 :29 ms, 在所有 Java 提交中击败了58.65%的用户
    public int minimumLengthEncoding(String[] words) {
        int count = 0;
        Map<TrieNode, Integer> hashMap = new HashMap<>();
        TrieNode root = new TrieNode('#');
        for (String str : words) {
            TrieNode node = root;
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                if (!node.children.containsKey(c)) {
                    TrieNode child = new TrieNode(c);
                    node.children.put(c, child);
                    node = child;
                    if (i == 0) {
                        hashMap.put(node, str.length());
                    }
                } else {
                    node = node.children.get(c);
                }
            }
        }
        for (Map.Entry<TrieNode, Integer> entry : hashMap.entrySet()) {
            if (entry.getKey().children.size() == 0) {
                count += entry.getValue() + 1;
            }
        }
        return count;
    }

    class TrieNode {

        public char value;
        public Map<Character, TrieNode> children;

        public TrieNode(char value) {
            this.value = value;
            this.children = new HashMap<>();
        }
    }


    //排序+暴力解：执行用时 :806 ms, 在所有 Java 提交中击败了9.96%的用户
    public int minimumLengthEncodingII(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].substring(words[j].length() - words[i].length()).equals(words[i])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count += words[i].length() + 1;
            }
        }
        return count + words[words.length - 1].length() + 1;
    }


    //暴力解: 执行用时 :376 ms, 在所有 Java 提交中击败了32.42%的用户
    public int minimumLengthEncodingI(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < words.length; j++) {
                if (matchI(words[j], words[i])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count += words[i].length() + 1;
            }
        }
        return count + words[words.length - 1].length() + 1;
    }

    public boolean matchI(String str1, String str2) {
        int i = str2.length() - 1;
        int j = str1.length() - 1;
        while (i >= 0) {
            if (str1.charAt(j) != str2.charAt(i)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}

package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/3/28 17:58
 * @Title 720. 词典中最长的单词
 * @Description //TODO
 **/

public class LongestWord {


    //字典树+深度优先: 执行用时 :11 ms, 在所有 Java 提交中击败了87.80%的用户
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode('#');
        root.isWord = true;
        for (String str : words) {
            TrieNode temp = root;
            for (char c : str.toCharArray()) {
                temp = temp.getChild(c);
            }
            temp.isWord = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        return dfs(root, stringBuilder, 0).substring(1);
    }

    public String dfs(TrieNode node, StringBuilder builder, int index) {
        if (!node.isWord) {
            return "";
        }
        builder.append(node.value);
        String res = builder.toString();
        int longest = builder.length();
        for (TrieNode n : node.children) {
            if (n != null) {
                String str = dfs(n, builder, index + 1);
                if (str.length() > longest) {
                    res = str;
                    longest = str.length();
                }
            }
        }
        builder.deleteCharAt(index);
        return res;
    }

    class TrieNode {
        public char value;
        public boolean isWord;
        public TrieNode[] children;

        public TrieNode(char value) {
            this.value = value;
            this.isWord = false;
            this.children = new TrieNode[26];
        }

        public TrieNode getChild(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode(c);
            }
            return children[c - 'a'];
        }
    }
}

package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/7/9 8:58
 * @Title 面试题 17.13. 恢复空格
 * @Description //TODO
 **/

public class Respace {

    public int respace(String[] dictionary, String sentence) {
        Trie root = new Trie();
        int n = sentence.length();
        for (String word : dictionary) {
            root.insert(word);
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            Trie curTrie = root;
            for (int j = i; j >= 1; j--) {
                int index = sentence.charAt(j - 1) - 'a';
                if (curTrie.next[index] == null) {
                    break;
                } else if (curTrie.next[index].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curTrie = curTrie.next[index];
            }
        }
        return dp[n];
    }

    class Trie {
        public Trie[] next;
        public boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String str) {
            Trie curTrie = this;
            for (int i = str.length() - 1; i >= 0; i--) {
                int index = str.charAt(i) - 'a';
                if (curTrie.next[index] == null) {
                    curTrie.next[index] = new Trie();
                }
                curTrie = curTrie.next[index];
            }
            curTrie.isEnd = true;
        }
    }
}

package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/11/16 16:21
 * @Title
 * @Description //TODO
 **/

public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(ans, i, n);
        }
        return ans;
    }

    public void dfs(List<Integer> ans, int num, int n) {
        if (num > n) return;
        ans.add(num);
        for (int i = 0; i < 10; i++) {
            dfs(ans, num * 10 + i, n);
        }
    }

    public List<Integer> lexicalOrder1(int n) {
        Trie trie = new Trie();
        for (int i = 1; i <= n; i++) {
            trie.insert(String.valueOf(i));
        }
        return trie.sort();
    }

    class Trie {
        Trie[] next = new Trie[10];
        boolean isStop = false;

        public void insert(String num) {
            Trie trie = this;
            for (int i = 0; i < num.length(); i++) {
                int index = num.charAt(i) - '0';
                if (trie.next[index] == null) {
                    trie.next[index] = new Trie();
                }
                trie = trie.next[index];
            }
            trie.isStop = true;
        }

        public List<Integer> sort() {
            List<Integer> ans = new ArrayList<>();
            dfs(ans, this, 0);
            return ans;
        }

        private void dfs(List<Integer> ans, Trie trie, int num) {
            if (trie.isStop && num > 0) ans.add(num);
            for (int i = 0; i < 10; i++) {
                if (trie.next[i] != null) {
                    dfs(ans, trie.next[i], num * 10 + i);
                }
            }
        }
    }
}

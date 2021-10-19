package leetcode.hard;

import java.util.*;

/**
 * @Author long
 * @Date 2021/9/16 10:01
 * @Title
 * @Description //TODO
 **/

public class FindWords {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, trie, ans, i, j);
            }
        }
        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, Trie node, Set<String> ans, int i, int j) {
        char c = board[i][j];
        int n = board.length;
        int m = board[0].length;
        if (!node.child.containsKey(c)) return;
        node = node.child.get(c);
        if (node.word != null) ans.add(node.word);
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < n && x >= 0 && y < m && y >= 0) {
                dfs(board, node, ans, x, y);
            }
        }
        board[i][j] = c;
    }

    class Trie {
        String word;
        Map<Character, Trie> child;
        boolean isWord;

        public Trie() {
            this.child = new HashMap<>();
            word = null;
            isWord = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                if (!node.child.containsKey(c)) {
                    node.child.put(c, new Trie());
                }
                node = node.child.get(c);
            }
            node.isWord = true;
            node.word = word;
        }
    }
}

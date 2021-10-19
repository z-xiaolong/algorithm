package leetcode.medium;

/**
 * @Author long
 * @Date 2021/10/19 9:30
 * @Title
 * @Description //TODO
 **/

public class WordDictionary {

    private final Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return root.search(word, root, 0);
    }

    static class Trie {

        private final Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                int next = word.charAt(i) - 'a';
                if (cur.children[next] == null) {
                    cur.children[next] = new Trie();
                }
                cur = cur.children[next];
            }
            cur.isEnd = true;
        }

        private boolean search(String word, Trie node, int index) {
            for (int i = index; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (Trie next : node.children) {
                        if (next != null && search(word, next, i + 1)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    int next = c - 'a';
                    if (node.children[next] == null) return false;
                    node = node.children[next];
                }
            }
            return node.isEnd;
        }
    }
}

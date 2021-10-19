package leetcode.easy;

/**
 * @Author long
 * @Date 2021/9/16 11:07
 * @Title
 * @Description //TODO
 **/

public class Trie {

    private final Trie[] children;
    private boolean isWord;

    public Trie() {
        children = new Trie[26];
        isWord = false;
    }


    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }


    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isWord;
    }


    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }
}

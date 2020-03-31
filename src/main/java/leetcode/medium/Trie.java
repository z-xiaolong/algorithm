package leetcode.medium;

import leetcode.entity.TrieNode;

/**
 * @Author long
 * @Date 2020/3/28 16:22
 * @Title 208. 实现 Trie (前缀树)
 * @Description //TODO
 **/

public class Trie {


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true
    }


    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode('#');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int length = word.length();
        TrieNode node = root;
        int i = 0;
        while (i < length) {
            char c = word.charAt(i);
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                TrieNode childNode = new TrieNode(c);
                node.children.put(c, childNode);
                node = childNode;
            }
            i++;
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchWith(word);
        if (node == null) {
            return false;
        }
        return node.isWord;
    }

    public TrieNode searchWith(String word) {
        int length = word.length();
        int i = 0;
        TrieNode node = root;
        while (i < length) {
            char c = word.charAt(i);
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                return null;
            }
            i++;
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchWith(prefix) != null;
    }
}

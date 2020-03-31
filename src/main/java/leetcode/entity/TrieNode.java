package leetcode.entity;


import leetcode.medium.Trie;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author long
 * @Date 2020/3/28 16:13
 * @Title
 * @Description //TODO
 **/

public class TrieNode {

    public boolean isWord;
    public char value;
    public Map<Character, TrieNode> children;

    public TrieNode(char value) {
        this.value = value;
        this.isWord = false;
        this.children = new TreeMap<>();
    }
}

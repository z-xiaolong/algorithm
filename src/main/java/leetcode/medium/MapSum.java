package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/7/9 10:56
 * @Title 677. 键值映射
 * @Description //TODO
 **/

public class MapSum {


    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple",3);
        mapSum.sum("apple");
        mapSum.insert("app",2);
        mapSum.sum("ap");
    }

    /**
     * Initialize your data structure here.
     */

    private Trie root;
    public Map<String, Integer> map = new HashMap<>();

    public MapSum() {
        root = new Trie();
    }

    public void insert(String key, int val) {
        root.insert(key, val);
    }

    public int sum(String prefix) {
        return root.getSum(prefix);
    }

    class Trie {

        public Trie[] next;
        public int value;

        public Trie() {
            next = new Trie[128];
            value = 0;
        }

        public void insert(String s, int val) {
            int temp = val;
            if (map.containsKey(s)) {
                val = val - map.get(s);
            }
            map.put(s, temp);
            Trie curTrie = this;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i);
                if (curTrie.next[index] == null) {
                    curTrie.next[index] = new Trie();
                }
                curTrie.next[index].value += val;
                curTrie = curTrie.next[index];
            }
        }

        public int getSum(String prefix) {
            Trie curTire = this;
            int sum = 0;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i);
                if (curTire.next[index] == null) return 0;
                sum = curTire.next[index].value;
                curTire = curTire.next[index];
            }
            return sum;
        }
    }
}

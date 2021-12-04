package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/11/16 20:46
 * @Title
 * @Description //TODO
 **/

public class ReplaceWords {

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        List<String> dic = new ArrayList<>();
        String sentence = "the cattle was rattled by the battery";
        dic.add("cat");
        dic.add("rat");
        dic.add("bat");
        replaceWords.replaceWords(dic, sentence);
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String dic : dictionary) {
            trie.insert(dic);
        }
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            String replace = trie.search(word);
            if (replace != null)
                builder.append(replace);
            else
                builder.append(word);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    class Trie {
        Trie[] next = new Trie[26];
        boolean isStop;
        String word = null;

        public void insert(String word) {
            Trie trie = this;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                int index = word.charAt(i) - 'a';
                if (trie.next[index] == null) {
                    trie.next[index] = new Trie();
                }
                trie = trie.next[index];
            }
            trie.isStop = true;
            trie.word = word;
        }

        public String search(String word) {
            Trie trie = this;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                int index = word.charAt(i) - 'a';
                if (trie.next[index] != null) {
                    trie = trie.next[index];
                    if (trie.isStop) break;
                } else {
                    return null;
                }
            }
            return trie.word;
        }
    }
}

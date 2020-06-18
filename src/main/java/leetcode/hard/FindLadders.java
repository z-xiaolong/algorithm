package leetcode.hard;

import java.util.*;

/**
 * @Author long
 * @Date 2020/6/7 9:12
 * @Title 126. 单词接龙 II
 * @Description //TODO
 **/

public class FindLadders {

    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        findLadders.findLadders(beginWord, endWord, wordList);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> output = new LinkedList<>();
        Map<String, List<String>> hashMap = new HashMap<>();
        if (!wordSet.contains(endWord)) {
            return output;
        }
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        hashMap.put(beginWord, list);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size > 0) {
                String word = queue.poll();
                wordSet.remove(word);
                Set<String> set = getNextWordSet(word, wordSet);
                for (String w : set) {
                    queue.offer(w);
                }
                size--;
            }
        }
        return output;
    }

    public void dfs(String endWord, List<String> list, Set<String> nextWord, Set<String> wordSet, List<List<String>> output) {

    }

    public Set<String> getNextWordSet(String word, Set<String> set) {
        Set<String> wordSet = new HashSet<>();
        for (String w : set) {
            if (isSimilar(word, w)) {
                wordSet.add(w);
            }
        }
        return wordSet;
    }

    private int length = Integer.MAX_VALUE;

    public List<List<String>> findLaddersI(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> output = new LinkedList<>();
        if (!set.contains(endWord)) {
            return output;
        }
        List<String> list = new LinkedList<>();
        list.add(beginWord);
        backtrack(output, beginWord, endWord, set, list);
        return output;
    }

    public void backtrack(List<List<String>> output, String word, String endWord, Set<String> wordSet, List<String> list) {
        if (list.size() > length) return;
        if (word.equals(endWord)) {
            if (length > list.size()) {
                output.clear();
                length = list.size();
            }
            output.add(new ArrayList<>(list));
            return;
        }
        Set<String> set = getSet(word, wordSet);
        wordSet.removeAll(set);
        for (String w : set) {
            list.add(w);
            backtrack(output, w, endWord, wordSet, list);
            list.remove(list.size() - 1);
        }
        wordSet.addAll(set);
    }

    public Set<String> getSet(String word, Set<String> wordSet) {
        Set<String> set = new HashSet<>();
        for (String w : wordSet) {
            if (isSimilar(word, w))
                set.add(w);
        }
        return set;
    }

    public boolean isSimilar(String word1, String word2) {
        int n = word1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count == 2) return false;
        }
        return count == 1;
    }
}

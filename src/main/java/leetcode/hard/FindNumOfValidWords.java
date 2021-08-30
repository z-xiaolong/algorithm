package leetcode.hard;

import java.util.*;

/**
 * @Author long
 * @Date 2021/2/26 19:11
 * @Title
 * @Description //TODO
 **/

public class FindNumOfValidWords {

    public static void main(String[] args) {
        FindNumOfValidWords findNumOfValidWords = new FindNumOfValidWords();
        String[] words = new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        findNumOfValidWords.findNumOfValidWords(words, puzzles);

    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int hash = 0;
            for (char c : word.toCharArray()) {
                hash |= 1 << (c - 'a');
            }
            if (Integer.bitCount(hash) <= 7) {
                map.put(hash, map.getOrDefault(hash, 0) + 1);
            }
        }
        for (String puzzle : puzzles) {
            int count = 0;
            char[] chars = puzzle.toCharArray();
            int hash = 1 << (chars[0] - 'a');
            for (int i = 0; i < (1 << 6); i++) {
                int mask = hash;
                for (int j = 0; j < 6; j++) {
                    if (((i >> j) & 1) == 1) {
                        mask |= 1 << (chars[j + 1] - 'a');
                    }
                }
                count += map.getOrDefault(mask, 0);
            }
            ans.add(count);
        }
        return ans;
    }


    public Set<Integer> subSet(String puzzle) {
        char[] chars = puzzle.toCharArray();
        int size = chars.length;
        int n = 1 << size;
        int hash = 1 << (chars[0] - 'a');
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int subHash = hash;
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) == 1) {
                    subHash |= 1 << (chars[j] - 'a');
                }
            }
            set.add(subHash);
        }
        return set;
    }


    public static int hash(String word) {
        int hash = 0;
        for (char c : word.toCharArray()) {
            hash |= 1 << (c - 'a');
        }
        return hash;
    }


}

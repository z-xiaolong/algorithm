package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/9/28 19:49
 * @Title
 * @Description //TODO
 **/

public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int m = words.length;
        int wordLen = words[0].length();
        int allWord = wordLen * m;
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i + allWord <= n; i++) {
            String sub = s.substring(i, i + allWord);
            Map<String, Integer> subMap = new HashMap<>();
            for (int j = 0; j + wordLen <= allWord; j += wordLen) {
                String w = sub.substring(j, j + wordLen);
                if (!wordMap.containsKey(w)) break;
                subMap.put(w, subMap.getOrDefault(w, 0) + 1);
            }
            boolean flag = true;
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                String k = entry.getKey();
                int v = entry.getValue();
                if (subMap.getOrDefault(k, 0) != v) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans.add(i);
        }
        return ans;
    }
}

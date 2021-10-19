package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2021/10/8 9:43
 * @Title
 * @Description //TODO
 **/

public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        Set<String> ans = new HashSet<>();
        Set<String> has = new HashSet<>();
        int k = 10;
        for (int i = 0; i + k < n; i++) {
            String sub = s.substring(i, i + k);
            if (has.contains(sub)) {
                ans.add(sub);
            } else {
                has.add(sub);
            }
        }
         LinkedList<Integer> list = new LinkedList<>();

        return new ArrayList<>(ans);
    }
}

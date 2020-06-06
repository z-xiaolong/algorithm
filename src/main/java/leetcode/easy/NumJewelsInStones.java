package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/4/27 11:11
 * @Title 771. 宝石与石头
 * @Description //TODO
 **/

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int num = 0;
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        for (char c : S.toCharArray()) {
            if (set.contains(c)) num++;
        }
        return num;
    }
}

package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2020/5/2 10:50
 * @Title 面试题 17.18. 最短超串
 * @Description //TODO
 **/

public class ShortestSeq {

    //执行用时 :29 ms, 在所有 Java 提交中击败了95.16%的用户
    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> need = new HashMap<>(small.length);
        for (int num : small) {
            need.put(num, need.getOrDefault(num, 0) + 1);
        }
        int i = 0, j = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int valid = 0;
        while (right < big.length) {
            if (need.containsKey(big[right])) {
                int count = need.get(big[right]);
                need.put(big[right], count - 1);
                if (count == 1) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < j - i) {
                    i = left;
                    j = right;
                }
                if (need.containsKey(big[left])) {
                    int count = need.get(big[left]);
                    need.put(big[left], count + 1);
                    if (count + 1 > 0) {
                        valid--;
                    }
                }
                left++;
            }
            right++;
        }
        return j - i == Integer.MAX_VALUE ? new int[0] : new int[]{i, j};
    }
}

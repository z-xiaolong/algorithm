package leetcode.medium;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/6/6 9:15
 * @Title 128. 最长连续序列
 * @Description //TODO
 **/

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLongest = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLongest++;
                }
                longest = Math.max(longest, curLongest);
            }
        }
        return longest;
    }
}

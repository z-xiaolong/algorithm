package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/4/15 14:54
 * @Title 128. 最长连续序列
 * @Description //TODO
 **/

public class LongestConsecutive {


    //Set 优化后：
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int n = num;
                while (set.contains(n + 1)) {
                    n++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    //Set数据结构：853 ms, 在所有 Java 提交中击败了5.69%的用户
    public int longestConsecutiveI(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                int count = 0;
                int n = num;
                while (set.contains(n)) {
                    n++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}

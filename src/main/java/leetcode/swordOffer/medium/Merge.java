package leetcode.swordOffer.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/4/16 9:53
 * @Title 56. 合并区间
 * @Description //TODO
 **/

public class Merge {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length == 0) return new int[0][];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> output = new LinkedList<>();
        for (int i = 0; i < length - 1; i++) {
            if (intervals[i][1] < intervals[i + 1][0]) {
                output.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
            }
        }
        output.add(new int[]{intervals[length - 1][0], intervals[length - 1][1]});
        return output.toArray(new int[0][]);
    }
}

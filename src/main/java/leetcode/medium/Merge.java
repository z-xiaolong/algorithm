package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/3/18 11:27
 * @Title 56. 合并区间
 * @Description //TODO
 **/

public class Merge {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4}, {0, 4}};
        merge(intervals);
    }


    //不排序
    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length == 0) {
            return new int[0][];
        }
        List<int[]> list = new LinkedList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] > right) {
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else if (intervals[i][1] >= right) {
                right = intervals[i][1];
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[0][]);
    }

    //排序后合并：执行用时 :9 ms, 在所有 Java 提交中击败了56.16%的用户
    public static int[][] mergeI(int[][] intervals) {
        int length = intervals.length;
        if (length == 0) {
            return new int[0][];
        }
        List<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] > right) {
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else if (intervals[i][1] >= right) {
                right = intervals[i][1];
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[0][]);
    }
}

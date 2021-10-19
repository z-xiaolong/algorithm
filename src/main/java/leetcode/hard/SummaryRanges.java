package leetcode.hard;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author long
 * @Date 2021/10/9 9:39
 * @Title
 * @Description //TODO
 **/

public class SummaryRanges {

    TreeSet<int[]> intervals;

    public SummaryRanges() {
        this.intervals = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        intervals.add(new int[]{-10, -10});
        intervals.add(new int[]{10010, 10010});
    }

    public void addNum(int val) {
        int[] cur = new int[]{val, val};
        int[] prev = intervals.floor(cur);
        int[] next = intervals.ceiling(cur);
        if (prev[1] < val - 1 && next[0] > val + 1) {
            intervals.add(cur);
        } else if (prev[1] == val - 1 && next[0] > val + 1) {
            prev[1] = val;
        } else if (prev[1] < val - 1 && next[0] == val + 1) {
            intervals.remove(next);
            next[0] = val;
            intervals.add(next);
        } else if (prev[1] == val - 1 && next[0] == val + 1) {
            intervals.remove(next);
            prev[1] = next[1];
        }
    }

    public int[][] getIntervals() {
        int n = intervals.size() - 2;
        int[][] ans = new int[n][2];
        Iterator<int[]> iterator = intervals.iterator();
        iterator.next();
        for (int i = 0; i < n && iterator.hasNext(); i++) {
            int[] e = iterator.next();
            ans[i][0] = e[0];
            ans[i][1] = e[1];
        }
        return ans;
    }


}

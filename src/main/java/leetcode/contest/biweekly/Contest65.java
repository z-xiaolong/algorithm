package leetcode.contest.biweekly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/10/31 14:59
 * @Title
 * @Description //TODO
 **/

public class Contest65 {
    public static void main(String[] args) {
        int[][] queries = new int[][]{{2, 5}, {5, 9}};
        platesBetweenCandles("**|**|***|", queries);
    }


    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] plates = new int[n]; //碟子
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                plates[i] = 1;
                if (i > 0) left[i] = left[i - 1];
            } else {
                left[i] = i;
            }
            if (i > 0) {
                plates[i] += plates[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                right[i] = i;
            } else if (i < n - 1) {
                right[i] = right[i + 1];
            }
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int l = right[query[0]];
            int r = left[query[1]];
            if (l > r) ans[i] = 0;
            else ans[i] = plates[r] - plates[l];
        }
        return ans;
    }


    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int[] next = new int[n + 1];
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        for (int i = n - 1; i >= 0; i--) {
            next[i] = Math.max(next[i + 1], events[i][2]);
        }
        int max = 0;
        for (int[] event : events) {
            int end = binarySearch(events, event[1]);
            max = Math.max(max, event[2] + next[end]);
        }
        return max;
    }

    public int binarySearch(int[][] events, int end) {
        int left = 0;
        int right = events.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : arr) {
            if (map.get(s) == 1) k--;
            if (k == 0) return s;
        }
        return "";
    }
}

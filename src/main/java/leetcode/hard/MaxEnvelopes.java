package leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author long
 * @Date 2020/5/29 9:56
 * @Title 354. 俄罗斯套娃信封问题
 * @Description //TODO
 **/

public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;
        int len = 1;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o2[1] - o1[1];
        });
        int[] d = new int[n + 1];
        d[len] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > d[len]) d[++len] = envelopes[i][1];
            else {
                int left = 1;
                int right = len;
                int pos = 0;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (d[mid] < envelopes[i][1]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                d[pos + 1] = envelopes[i][1];
            }
        }
        return len;
    }
}

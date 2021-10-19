package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/9/28 21:31
 * @Title
 * @Description //TODO
 **/

public class MaxPoints {

    public int maxPoints(int[][] points) {
        int n = points.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcd = gcd(Math.abs(x), Math.abs(y));
                    x /= gcd;
                    y /= gcd;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int v = entry.getValue();
                ans = Math.max(ans, v + 1);
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}

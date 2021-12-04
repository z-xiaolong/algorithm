package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/11/9 9:55
 * @Title
 * @Description //TODO
 **/

public class FindMinStep {


    int INF = 0x3f3f3f3f;
    String hand;
    int m;
    Map<String, Integer> map = new HashMap<>();

    public int findMinStep(String board, String hand) {
        this.hand = hand;
        m = this.hand.length();
        int ans = dfs(board, 1 << m);
        return ans == INF ? -1 : ans;
    }

    public int dfs(String board, int cur) {
        if (board.length() == 0) return 0;
        if (map.containsKey(board)) return map.get(board);
        int ans = INF;
        int n = board.length();
        for (int i = 0; i < m; i++) {
            if (((cur >> i) & 1) == 1) continue;
            int next = (1 << i) | cur;
            for (int j = 0; j <= n; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(board, 0, j).append(hand.charAt(i));
                if (j != n) sb.append(board.substring(j));
                int k = j;
                while (0 <= k && k < sb.length()) {
                    char c = sb.charAt(k);
                    int l = k;
                    int r = k;
                    while (l >= 0 && sb.charAt(l) == c) l--;
                    while (r < sb.length() && sb.charAt(r) == c) r++;
                    if (r - l - 1 >= 3) {
                        sb.delete(l + 1, r);
                        k = l >= 0 ? l : r;
                    } else {
                        break;
                    }
                }
                ans = Math.min(ans, dfs(sb.toString(), next) + 1);
            }
        }
        map.put(board, ans);
        return ans;
    }

}

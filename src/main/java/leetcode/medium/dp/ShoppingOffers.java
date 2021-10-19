package leetcode.medium.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/10/16 21:17
 * @Title
 * @Description //TODO
 **/

public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        return dfs(map, needs, price, special);
    }

    public int dfs(Map<List<Integer>, Integer> map, List<Integer> needs, List<Integer> price, List<List<Integer>> special) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
        int min = 0;
        for (int i = 0; i < needs.size(); i++) {
            min += price.get(i) * needs.get(i);
        }
        for (List<Integer> s : special) {
            List<Integer> copy = new ArrayList<>(needs);
            boolean flag = true;
            for (int i = 0; i < copy.size(); i++) {
                if (s.get(i) > copy.get(i)) {
                    flag = false;
                    break;
                }
                copy.set(i, copy.get(i) - s.get(i));
            }
            if (flag) {
                min = Math.min(min, dfs(map, copy, price, special) + s.get(s.size() - 1));
            }
        }
        map.put(needs, min);
        return min;
    }


    public int getKthMagicNumber(int k) {
        if (k == 1) {
            return 1;
        }
        int[] dp = new int[k];
        dp[0] = 1;
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(dp[p3] * 3, Math.max(dp[p5] * 5, dp[p7] * 7));
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
            if (dp[i] == dp[p7] * 7) p7++;
        }
        return dp[k - 1];
    }
}

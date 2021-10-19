package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/10/12 11:03
 * @Title
 * @Description //TODO
 **/

public class CanIWin {

    public static void main(String[] args) {
        //canIWin(1, 4);
    }


    //dp[i][state] = dp[i-1][state']
    public boolean canIWin(int max, int desiredTotal) {
        if (max >= desiredTotal) return true;
        if ((1 + max) * max / 2 < desiredTotal) return false;
        Boolean[] dp = new Boolean[1 << max];

        return dfs(dp, max, 0, desiredTotal);
    }

    public boolean dfs(Boolean[] dp, int max, int state, int desiredTotal) {
        if (dp[state] != null) {
            return dp[state];
        }
        for (int i = 1; i <= max; i++) {
            if ((state & (1 << (i - 1))) == 0) {
                int newState = state | (1 << (i - 1));
                if (i >= desiredTotal
                        || !dfs(dp, max, newState, desiredTotal - i)) {
                    dp[state] = true;
                    return dp[state];
                }
            }
        }
        dp[state] = false;
        return false;
    }


    public static final List<String> container = new ArrayList<>();

    static {
        for (int i = 1; i <= 10000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                container.add("FizzBuzz");
            } else if (i % 3 == 0) {
                container.add("Fizz");
            } else if (i % 5 == 0) {
                container.add("Buzz");
            } else {
                container.add(String.valueOf(i));
            }
        }
    }

    public List<String> fizzBuzz(int n) {
        return container.subList(0, n);
    }
}

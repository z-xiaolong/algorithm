package leetcode.medium;

/**
 * @Author long
 * @Date 2021/10/14 9:48
 * @Title
 * @Description //TODO
 **/

public class CountArrangement {

    public int countArrangement(int n) {
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = Integer.bitCount(i);
                if ((i & (1 << j)) != 0 && ((j + 1) % cnt == 0 || cnt % (j + 1) == 0)) {
                    dp[i] += dp[i - (1 << j)];
                }
            }
        }
        return dp[(1 << n) - 1];
    }


    public static void main(String[] args) {
        CountArrangement countArrangement = new CountArrangement();
        countArrangement.countAndSay(2);
    }

    public static final String[] container = new String[31];

    static {
        container[1] = "1";
        for (int i = 2; i < container.length; i++) {
            container[i] = count(container[i - 1]);
        }
    }

    public String countAndSay(int n) {
        return container[n];
    }

    private static String count(String s) {
        int n = s.length();
        if (n == 0) return "";
        StringBuilder builder = new StringBuilder();
        int cnt = 1;
        char c = s.charAt(0);
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i);
            if (c != ch) {
                builder.append(cnt).append(c);
                cnt = 1;
                c = ch;
            } else {
                cnt++;
            }
        }
        builder.append(cnt).append(c);
        return builder.toString();
    }
}

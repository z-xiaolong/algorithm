package leetcode.hard;

/**
 * @Author long
 * @Date 2021/9/27 10:35
 * @Title
 * @Description //TODO
 **/

//dp[i] = dp[i-1]*n + dp[i-2]*m
public class NumDecodings {

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        numDecodings.numDecodings("*********");
    }

    int mod = (int) 1e9 + 7;

    public int check1digit(char c) {
        if (c == '0') return 0;
        return c == '*' ? 9 : 1;
    }

    public int check2digit(char c1, char c2) {
        if (c1 == '*') {
            if (c2 == '*') return 15;
            return c2 > '6' ? 1 : 2;
        } else if (c1 > '0' && c1 <= '9') {
            if (c2 == '*') {
                if (c1 == '1') return 9;
                if (c1 == '2') return 6;
            } else {
                if (c1 == '1') return 1;
                if (c1 == '2') {
                    return c2 > '6' ? 0 : 1;
                }
            }
        }
        return 0;
    }

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        for (int i = 2; i <= n; i++) {
            char c2 = s.charAt(i - 1);
            char c1 = s.charAt(i - 2);
            dp[i] = (dp[i - 1] * check1digit(c2) + dp[i - 2] * check2digit(c1, c2)) % mod;
        }
        return (int) (dp[n] % mod);
    }


    public int numDecodings_tmp(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        for (int i = 2; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (c == '*') {
                dp[i] = dp[i - 1] * 9 % mod;
                char prev = s.charAt(i - 2);
                if (prev == '*') {
                    dp[i] = (dp[i] + dp[i - 2] * 15) % mod;
                } else if (prev == '1') {
                    dp[i] = (dp[i] + dp[i - 2] * 9) % mod;
                } else if (prev == '2') {
                    dp[i] = (dp[i] + dp[i - 2] * 6) % mod;
                }
            } else if (c == '0') {
                char prev = s.charAt(i - 2);
                if (prev == '1' || prev == '2') {
                    dp[i] = dp[i - 2];
                } else if (prev == '*') {
                    dp[i] = (dp[i - 2] * 2) % mod;
                }
            } else {
                dp[i] = dp[i - 1];
                char prev = s.charAt(i - 2);
                if (prev == '*') {
                    int cnt = c > '6' ? 1 : 2;
                    dp[i] = (dp[i] + dp[i - 2] * cnt) % mod;
                } else if (prev == '1') {
                    dp[i] += dp[i - 2];
                } else if (prev == '2' && c <= '6') {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return (int) (dp[n] % mod);
    }
}

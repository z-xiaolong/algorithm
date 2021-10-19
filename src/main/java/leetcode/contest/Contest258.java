package leetcode.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/9/12 9:47
 * @Title
 * @Description //TODO
 **/

public class Contest258 {
    public static void main(String[] args) {
    }

    public long interchangeableRectangles(int[][] rectangles) {
        int n = rectangles.length;
        long res = 0;
        Map<Double, Long> map = new HashMap<>();
        
        for (int i = n - 1; i >= 0; i--) {
            int[] rectangle = rectangles[i];
            double d = (double) rectangle[0] / (double) rectangle[1];
            if (map.containsKey(d)) {
                long v = map.get(d);
                res += v;
                map.put(d, v + 1);
            } else {
                map.put(d, 1L);
            }
        }
        return res;
    }


    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        return null;
    }

    int max = 0;

    public int maxProduct(String s) {
        StringBuilder choice = new StringBuilder();
        StringBuilder noChoice = new StringBuilder();
        dfs(s, choice, noChoice, 0);
        return max;
    }

    public void dfs(String s, StringBuilder choice, StringBuilder noChoice, int index) {
        if (index == s.length()) {
            max = Math.max(max, palindrome(choice.toString()) * palindrome(noChoice.toString()));
            return;
        }
        char c = s.charAt(index);
        dfs(s, choice.append(c), noChoice, index + 1);
        choice.deleteCharAt(choice.length() - 1);
        dfs(s, choice, noChoice.append(c), index + 1);
        noChoice.deleteCharAt(noChoice.length() - 1);
    }

    public int palindrome(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (chars[j] == chars[j + i]) {
                    dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
                } else {
                    dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }


    public long interchangeableRectangles1(int[][] rectangles) {
        long ans = 0;
        int n = rectangles.length;
        Map<String, Long> map = new HashMap<>();
        map.put(hash(rectangles[n - 1]), 1L);
        for (int i = n - 2; i >= 0; i--) {
            int[] r = rectangles[i];
            String hash = hash(r);
            if (map.containsKey(hash)) {
                long cnt = map.get(hash);
                ans += cnt;
                map.put(hash, cnt + 1);
            } else {
                map.put(hash, 1L);
            }
        }
        return ans;
    }

    public String hash(int[] r) {
        int gcd = GCD(r[0], r[1]);
        int a = r[0] / gcd;
        int b = r[1] / gcd;
        return a + "," + b;
    }

    public static int GCD(int m, int n) {
        int result;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

    public String reversePrefix(String word, char ch) {
        StringBuilder builder = new StringBuilder();
        int i;
        boolean flag = false;
        for (i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            builder.append(c);
            if (c == ch) {
                flag = true;
                break;
            }
        }
        if (!flag) return word;
        builder.reverse();
        return builder.toString() + word.substring(i);
    }
}

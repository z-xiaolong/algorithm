package leetcode.contest;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author long
 * @Date 2021/9/26 10:04
 * @Title
 * @Description //TODO
 **/

public class Contest260 {
    public static void main(String[] args) {

    }

    public int scoreOfStudents(String s, int[] answers) {
        int correct = answer(s);
        int n = s.length();
        Set<Integer>[][] dp = new Set[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                dp[i][i].add(c - '0');
            }
        }
        for (int i = 2; i < n; i += 2) {
            for (int j = 0; j + i < n; j += 2) {
                for (int k = j + 1; k < j + i; k += 2) {
                    for (int a : dp[j][k - 1]) {
                        for (int b : dp[k + 1][j + i]) {
                            if (s.charAt(k) == '*' && a * b <= 1000) {
                                dp[j][j + i].add(a * b);
                            } else if (s.charAt(k) == '+' && a + b <= 1000) {
                                dp[j][j + i].add(a + b);
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int answer : answers) {
            if (answer == correct) ans += 5;
            else if (dp[0][n - 1].contains(answer)) ans += 2;
        }
        return ans;
    }

    public int answer(String s) {
        int correct = 0;
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        boolean isProduct = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                isProduct = true;
            } else if (c != '+') {
                if (isProduct && !stack.isEmpty()) {
                    stack.push(stack.poll() * (c - '0'));
                    isProduct = false;
                } else {
                    stack.push(c - '0');
                }
            }
        }
        while (!stack.isEmpty()) {
            correct += stack.poll();
        }
        return correct;
    }

    public boolean placeWordInCrossword(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int k = word.length();
        char[] slot = new char[k];
        for (char[] chars : board) {
            int left = 0;
            for (int right = 0; right < m; right++) {
                char c = chars[right];
                if (c == '#') {
                    if (left == k && (valid(slot, word))) {
                        return true;
                    }
                    left = 0;
                } else {
                    if (left < k) {
                        slot[left] = c;
                    }
                    left++;
                }
            }
            if (left == k && (valid(slot, word))) {
                return true;
            }
        }
        for (int i = 0; i < m; i++) {
            int left = 0;
            for (char[] chars : board) {
                char c = chars[i];
                if (c == '#') {
                    if (left == k && (valid(slot, word))) {
                        return true;
                    }
                    left = 0;
                } else {
                    if (left < k) {
                        slot[left] = c;
                    }
                    left++;
                }
            }
            if (left == k && (valid(slot, word))) {
                return true;
            }
        }
        return false;
    }

    public boolean valid(char[] slot, String word) {
        int m = word.length();
        int i = 0;
        int j = m - 1;
        for (int k = 0; k < m; k++) {
            char c = word.charAt(k);
            if (c == slot[i] || slot[i] == ' ') i++;
            if (c == slot[j] || slot[j] == ' ') j--;
        }
        return i == m || j == -1;
    }

    public long gridGame(int[][] grid) {
        int m = grid[0].length;
        if (m == 1) return 0;
        long[][] prefix = new long[2][m]; //前缀
        long[][] suffix = new long[2][m]; //后缀
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                prefix[0][i] = grid[0][i];
                prefix[1][i] = grid[1][i];
            } else {
                prefix[0][i] = grid[0][i] + prefix[0][i - 1];
                prefix[1][i] = grid[1][i] + prefix[1][i - 1];
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            if (i == m - 1) {
                suffix[0][i] = grid[0][i];
                suffix[1][i] = grid[1][i];
            } else {
                suffix[0][i] = grid[0][i] + suffix[0][i + 1];
                suffix[1][i] = grid[1][i] + suffix[1][i + 1];
            }
        }
        long max = Math.min(suffix[0][1], prefix[1][m - 2]);
        for (int i = 1; i < m - 1; i++) {
            max = Math.min(max, Math.max(suffix[0][i + 1], prefix[1][i - 1]));
        }
        return max;
    }


    public int maximumDifference(int[] nums) {
        int min = 0;
        int max = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[min]) min = i;
            else if (nums[i] > nums[min]) {
                max = Math.max(max, nums[i] - nums[min]);
            }
        }
        return max;
    }

}

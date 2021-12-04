package leetcode.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author long
 * @Date 2021/10/24 10:14
 * @Title
 * @Description //TODO
 **/

public class Contest264 {


    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] degree = new int[n + 1];
        int[] dp = new int[n + 1];
        List<Integer>[] in = new List[n + 1];
        List<Integer>[] out = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            in[i] = new ArrayList<>();
            out[i] = new ArrayList<>();
        }
        for (int[] relation : relations) {
            degree[relation[1]]++;
            in[relation[0]].add(relation[1]);
            out[relation[1]].add(relation[0]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) set.add(i);
        }
        while (!set.isEmpty()) {
            Set<Integer> sub = new HashSet<>();
            for (int cur : set) {
                dp[cur] = time[cur - 1];
                int max = 0;
                for (int prev : out[cur]) {
                    max = Math.max(dp[prev], max);
                }
                for (int next : in[cur]) {
                    degree[next]--;
                    if (degree[next] == 0) {
                        sub.add(next);
                    }
                }
                dp[cur] += max;
            }
            set = sub;
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        long[] cnt = new long[n];
        int[] sum = new int[n];
        List<Integer>[] children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);
        }
        dfs(sum, children, 0);
        for (int i = 0; i < n; i++) {
            //List<Integer> child = children[i];
            long score = 1L;
            for (int child : children[i]) {
                score = score * sum[child];
            }
            if (parents[i] != -1) {
                score = score * (n - sum[i]);
            }
            cnt[i] = score;
        }
        long max = Integer.MIN_VALUE;
        for (long v : cnt) {
            max = Math.max(max, v);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] == max) ans++;
        }
        return ans;
    }

    public int dfs(int[] sum, List<Integer>[] children, int index) {
        int cnt = 1;
        for (int child : children[index]) {
            cnt += dfs(sum, children, child);
        }
        sum[index] = cnt;
        return cnt;
    }

    public int nextBeautifulNumber(int n) {
        int ans = n + 1;
        while (!valid(ans)) ans++;
        return ans;
    }

    public boolean valid(int num) {
        int[] cnt = new int[10];
        while (num > 0) {
            cnt[num % 10]++;
            num = num / 10;
        }
        if (cnt[0] > 1) return false;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0 && cnt[i] != i) return false;
        }
        return true;
    }

    /*public int nextBeautifulNumber(int n) {
        int len = 0;
        int num = n;
        int high = num;
        while (num > 0) {
            len++;
            high = num;
            num = num / 10;
        }
        if (high <= len) {

        }
    }*/


    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int cnt = 0;
        for (String word : words) {
            if (valid(word)) cnt++;
        }
        return cnt;
    }

    public boolean valid(String word) {
        if (word == null || "".equals(word)) return false;
        int sign = 0;
        int c = 0;
        int n = word.length();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (i == 0) {
                if ((ch < 'a' || ch > 'z') && n > 1) {
                    return false;
                }
            }
            if (ch == '-') {
                c++;
                if (i == word.length() - 1) return false;
                if (!Character.isLetter(word.charAt(i - 1)) || !Character.isLetter(word.charAt(i + 1))) {
                    return false;
                }
            }
            if (ch == '!' || ch == '.' || ch == ',') {
                sign++;
                if (i != n - 1) return false;
            }
            if (ch >= '0' && ch <= '9') return false;
        }
        return c <= 1 && sign <= 1;
    }


    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        int L = (int) Math.sqrt(area);
        for (; L <= area; L++) {
            if (area % L == 0) {
                int w = area / L;
                if (L >= w)
                    return new int[]{L, area / L};
                else
                    return new int[]{w, L};
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Contest264 contest = new Contest264();
        contest.removeInvalidParentheses("((i)");
    }

    Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int leftRemove = 0;
        int rightRemove = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') leftRemove++;
            else if (c == ')') {
                if (leftRemove == 0) rightRemove++;
                else leftRemove--;
            }
        }
        dfs(s, new StringBuilder(), leftRemove, rightRemove, 0, 0, 0);
        return new ArrayList<>(ans);
    }

    public void dfs(String s, StringBuilder builder, int leftRemove, int rightRemove, int left, int right, int index) {
        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && left == right)
                ans.add(builder.toString());
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            if (leftRemove > 0) {
                dfs(s, builder, leftRemove - 1, rightRemove, left, right, index + 1);
            }
            builder.append(c);
            dfs(s, builder, leftRemove, rightRemove, left + 1, right, index + 1);
            builder.deleteCharAt(builder.length() - 1);
        } else if (c == ')') {
            if (left == right) {
                if (rightRemove > 0) {
                    dfs(s, builder, leftRemove, rightRemove - 1, left, right, index + 1);
                }
            } else if (left > right) {
                if (rightRemove > 0) {
                    dfs(s, builder, leftRemove, rightRemove - 1, left, right, index + 1);
                }
                builder.append(c);
                dfs(s, builder, leftRemove, rightRemove, left, right + 1, index + 1);
                builder.deleteCharAt(builder.length() - 1);
            }
        } else {
            builder.append(c);
            dfs(s, builder, leftRemove, rightRemove, left, right, index + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }


}

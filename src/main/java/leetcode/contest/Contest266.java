package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2021/11/7 10:16
 * @Title
 * @Description //TODO
 **/

public class Contest266 {
    public static void main(String[] args) {
        Contest266 contest = new Contest266();
        contest.countVowels("aba");
    }

    int max = 0;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[]{edge[1], edge[2]});
            lists[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(lists, visited, values, 0, maxTime, values[0]);
        return max;
    }


    public void dfs(List<int[]>[] lists, boolean[] visited, int[] values, int cur, int time, int v) {
        if (time < 0) return;
        if (cur == 0) {
            max = Math.max(max, v);
        }
        List<int[]> list = lists[cur];
        for (int[] next : list) {
            if (!visited[next[0]]) {
                visited[next[0]] = true;
                dfs(lists, visited, values, next[0], time - next[1], v + values[next[0]]);
                visited[next[0]] = false;
            } else {
                dfs(lists, visited, values, next[0], time - next[1], v);
            }
        }
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int right = Arrays.stream(quantities).max().getAsInt();
        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (valid(quantities, n, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean valid(int[] quantities, int n, int mid) {
        for (int q : quantities) {
            n -= q / mid;
            if (q % mid != 0) n--;
            if (n < 0) return false;
        }
        return true;
    }


    static Set<Character> set = new HashSet<>();

    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }

    public long countVowels(String word) {
        int n = word.length();
        long[] cnt = new long[n + 1];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            cnt[i + 1] = cnt[i];
            if (set.contains(word.charAt(i))) cnt[i + 1]++;
            sum += cnt[i + 1];
        }
        long ans = sum;
        for (int i = 1; i < n; i++) {
            if (set.contains(word.charAt(i - 1))) {
                sum -= n - i + 1;
            }
            ans += sum;
        }
        return ans;
    }


    public int countVowelSubstrings(String word) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ans = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            Set<Character> contains = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (set.contains(word.charAt(j))) {
                    contains.add(word.charAt(j));
                    if (contains.size() == 5) ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }


}

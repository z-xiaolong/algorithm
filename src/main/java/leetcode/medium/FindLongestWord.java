package leetcode.medium;

import java.util.List;

/**
 * @Author long
 * @Date 2021/9/14 11:10
 * @Title
 * @Description //TODO
 **/

public class FindLongestWord {

    public String findLongestWord(String s, List<String> dictionary) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        String ans = "";
        for (String d : dictionary) {
            if (d.length() < ans.length()) continue;
            if (isValid(s, d, map)) {
                if (ans.length() < d.length() || d.compareTo(ans) < 0)
                    ans = d;
            }
        }
        return ans;
    }

    public boolean isValid(String s, String d, int[] map) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < d.length()) {
            char a = s.charAt(i);
            char b = d.charAt(j);
            if (map[b - 'a'] == 0) return false;
            if (a == b) {
                j++;
            }
            i++;
        }
        return j == d.length();
    }

    public void deal(int n, int[] business) {
        int k = business.length;
        int head = 1;
        int tail = head + 1;
        for (int i = 0; i < k; i++) {
            int ans = 0;
            if (head > business[i]) {
                ans = business[i];
                head--;
            } else {
                ans += head - 1;
                int needed = business[i] - head + 1;
                ans += (tail - head) * needed;
                head = business[i] - 1;
            }
            System.out.println(ans);
        }
    }
}

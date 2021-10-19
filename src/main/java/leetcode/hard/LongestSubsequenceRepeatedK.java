package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/9/19 15:28
 * @Title
 * @Description //TODO
 **/

public class LongestSubsequenceRepeatedK {

    public static void main(String[] args) {
        LongestSubsequenceRepeatedK test = new LongestSubsequenceRepeatedK();
        test.longestSubsequenceRepeatedK("kkrkmktkkhqdlkzqfdmkkghjk", 9);
    }

    // n < 8*k

    String ans = "";

    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= k) {
                list.add(new int[]{i, cnt[i] / k});
            }
        }
        char[] sub = new char[8];
        dfs(chars, list, sub, 0, k);
        return ans;
    }

    public void dfs(char[] s, List<int[]> list, char[] sub, int index, int k) {
        if (index == sub.length) return;
        if (index >= ans.length() && isValid(s, sub, index, k)) {
            String newStr = String.valueOf(sub, 0, index);
            if (newStr.length() >= ans.length() && compare(ans, newStr) < 0) {
                ans = newStr;
            }
        }
        for (int[] c : list) {
            if (c[1] > 0) {
                sub[index] = (char) (c[0] + 'a');
                c[1]--;
                dfs(s, list, sub, index + 1, k);
                c[1]++;
            }
        }
    }

    public int compare(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) return 1;
        else if (m < n) return -1;
        for (int i = 0; i < m; i++) {
            int sub = s1.charAt(i) - s2.charAt(i);
            if (sub != 0) return sub;
        }
        return 0;
    }

    public boolean isValid(char[] s, char[] sub, int index, int k) {
        int j = 0;
        for (char c : s) {
            if (c == sub[j]) {
                j++;
                if (j == index) {
                    k--;
                    j = 0;
                    if (k == 0) return true;
                }
            }
        }
        return false;
    }
}

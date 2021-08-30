package leetcode.medium;

/**
 * @Author long
 * @Date 2021/2/27 10:30
 * @Title
 * @Description //TODO
 **/

public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        longestSubstring.longestSubstring("weitong", 2);
    }

    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int left, int right, int k) {
        int[] map = new int[26];
        for (int i = left; i <= right; i++) {
            map[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0 && map[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return right - left + 1;
        }
        int i = left;
        int ans = 0;

        while (i <= right) {
            while (i <= right && s.charAt(i) == split) {
                i++;
            }
            if (i > right) {
                break;
            }
            int start = i;
            while (i < right && s.charAt(i) != split) {
                i++;
            }
            ans = Math.max(dfs(s, start, i - 1, k), ans);
        }
        return ans;
    }
}

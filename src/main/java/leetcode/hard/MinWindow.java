package leetcode.hard;

/**
 * @Author long
 * @Date 2020/5/2 7:55
 * @Title 76. 最小覆盖子串
 * @Description //TODO
 **/

public class MinWindow {

    public static void main(String[] args) {
        MinWindow window = new MinWindow();
        window.minWindow("ABC", "ABC");
    }

    //执行用时 :3 ms, 在所有 Java 提交中击败了99.22%的用户
    public String minWindow(String s, String t) {
        if (t.length() == 0) return "";
        int[] need = new int[128];
        int[] have = new int[128];
        int length = s.length();
        int i = 0, j = length + 1;
        int needs = 0;
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        for (int num : need) {
            if (num > 0) needs++;
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < length) {
            char c = s.charAt(right);
            have[c]++;
            right++;
            if (need[c] > 0 && need[c] == have[c]) valid++;
            while (needs == valid) {
                if (right - left < j - i) {
                    j = right;
                    i = left;
                }
                char cLeft = s.charAt(left);
                have[cLeft]--;
                if (have[cLeft] < need[cLeft]) valid--;
                left++;
            }
        }
        return j - i != length + 1 ? s.substring(i, j) : "";
    }
}

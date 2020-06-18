package leetcode.byteDance;

/**
 * @Author long
 * @Date 2020/6/17 11:54
 * @Title 字符串的排列
 * @Description //TODO
 **/

public class CheckInclusion {

    public static void main(String[] args) {
        checkInclusion("ab", "eidboaoo");
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
        }
        int needLength = s1.length();
        int[] have = new int[26];
        int right;
        int left = -1;
        int haveNum = 0;
        for (right = 0; right < s2.length() - needLength; right++) {
            int c = s2.charAt(right) - 'a';
            if (need[c] != 0) {
                have[c]++;
                while (have[c] > need[c]) {
                    have[s2.charAt(left + 1) - 'a']--;
                    haveNum--;
                    left++;
                }
                haveNum++;
                if (haveNum == needLength) return true;
            } else {
                for (int i = left + 1; i < right; i++) {
                    have[s2.charAt(i) - 'a']--;
                }
                haveNum = 0;
                left = right;
            }
        }
        return false;
    }

}

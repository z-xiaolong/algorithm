package leetcode.hard;

/**
 * @Author long
 * @Date 2020/4/19 9:19
 * @Title 466. 统计重复个数
 * @Description //TODO
 **/

public class GetMaxRepetitions {

    //TODO
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1.length() == 0 || s2.length() == 0 || n1 == 0 || n2 == 0) return 0;
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int count = 0;
        int index = 0;
        int[] indexr = new int[s2Chars.length + 1];
        int[] countr = new int[s2Chars.length + 1];
        for (int i = 0; i < n1; i++) {
            for (char s1Char : s1Chars) {
                if (s1Char == s2Chars[index]) {
                    if (index == s2Chars.length - 1) {
                        count++;
                        index = 0;
                    } else {
                        index++;
                    }
                }
            }
            countr[i] = count;
            indexr[i] = index;
            for (int k = 0; k < i; k++) {
                if (indexr[k] == index) {
                    int prev_count = countr[k];
                    int pattern_count = ((n1 - 1 - k) / (i - k)) * (countr[i] - countr[k]);
                    int remain_count = countr[k + (n1 - 1 - k) % (i - k)] - countr[k];
                    return (prev_count + pattern_count + remain_count) / n2;
                }
            }
        }
        return countr[n1 - 1] / n2;
    }
}

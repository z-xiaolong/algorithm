package leetcode.easy;

/**
 * @Author long
 * @Date 2020/4/27 9:59
 * @Title 5392. 分割字符串的最大得分
 * @Description //TODO
 **/

public class MaxScore {

    //优化空间
    public int maxScore(String s) {
        int n = s.length();
        int max = 0;
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') count0++;
        }
        for (int i = n - 1; i > 0; i--) {
            if (s.charAt(i) == '1') count1++;
            else count0--;
            max = Math.max(max, count0 + count1);
        }
        return max;
    }


    public int maxScoreI(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int max = 0;
        int[] left = new int[n];
        int[] right = new int[n + 1];
        for (int i = 1; i < n; i++) {
            if (chars[i - 1] == '0') {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = left[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == '1') {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = right[i + 1];
            }
        }
        for (int i = 1; i < n; i++) {
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }
}

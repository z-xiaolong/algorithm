package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/5/23 9:15
 * @Title
 * @Description //TODO
 **/

public class MinWindow {
    public String minWindow(String s, String t) {
        int n = s.length();
        if (t.length() == 0 || n == 0) return "";
        int needs = 0;
        int[] chars = new int[128];
        for (char c : t.toCharArray()) {
            chars[c]++;
            if (chars[c] == 1) needs++;
        }
        int[] flag = new int[128];
        int left = 0;
        int right = n + 1;
        int count = 0;
        for (int i = 0, j = 0; i < n; i++) {
            char c = s.charAt(i);
            flag[c]++;
            if (flag[c] == chars[c]) count++;
            while (count == needs) {
                if (i - j < right - left) {
                    right = i;
                    left = j;
                }
                char c1 = s.charAt(j);
                flag[c1]--;
                if (chars[c1] > flag[c1]) {
                    count--;
                }
                j++;
            }
        }
        return right - left == n + 1 ? "" : s.substring(left, right + 1);
    }

    public int[] replaceElements(int[] arr) {
        int n = arr.length - 1;
        int pre = arr[n];
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = Math.max(arr[i + 1], pre);
            pre = temp;
        }
        arr[n] = -1;
        return arr;
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> output = new LinkedList<>();
        int left = 0;
        int length = S.length();
        while (left < length) {
            int i = left;
            char c = S.charAt(left);
            while (i < length && S.charAt(i) == c) {
                i++;
            }
            if (i - left >= 3) {
                List<Integer> list = new ArrayList<>(2);
                list.add(left);
                list.add(i - 1);
                output.add(list);
            }
            left = i;
        }
        return output;
    }
}

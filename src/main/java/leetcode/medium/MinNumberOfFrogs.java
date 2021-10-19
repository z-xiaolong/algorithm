package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author long
 * @Date 2021/9/17 16:50
 * @Title
 * @Description //TODO
 **/

public class MinNumberOfFrogs {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                c++;
                if (k > 0) k--;   //关键核心思想
            } else if (ch == 'r' && c > 0) {
                r++;
                c--;
            } else if (ch == 'o' && r > 0) {
                o++;
                r--;
            } else if (ch == 'a' && o > 0) {
                a++;
                o--;
            } else if (ch =='k' && a > 0) {
                k++;
                a--;
            } else {
                return -1;
            }
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) return -1;
        return k;
    }

    public int minNumberOfFrogs1(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        int c = 0, r = 0, o = 0, a = 0;
        int[] list = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < croakOfFrogs.length(); ++i) {
            char ch = croakOfFrogs.charAt(i);
            if (ch == 'c') {
                queue.add(i);
                c++;
            } else if (ch == 'r' && c > 0) {
                r++;
                c--;
            } else if (ch == 'o' && r > 0) {
                o++;
                r--;
            } else if (ch == 'a' && o > 0) {
                a++;
                o--;
            } else if (ch == 'k' && a > 0) {
                a--;
                int l = queue.poll();
                list[l]++;
                list[i + 1]--;
            } else {
                return -1;
            }
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) return -1;
        int min = -1;
        int cnt = 0;
        for (int i : list) {
            cnt += i;
            min = Math.max(cnt, min);
        }
        return min;
    }
}

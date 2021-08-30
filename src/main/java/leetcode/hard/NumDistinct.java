package leetcode.hard;

import leetcode.entity.ListNode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.SocketChannel;

/**
 * @Author long
 * @Date 2021/3/17 10:23
 * @Title
 * @Description //TODO
 **/

public class NumDistinct {

    public static void main(String[] args) throws IOException {

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        head = tmp;
        while (m > 1) {
            head = head.next;
            m--;
            n--;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode tail = cur;
        ListNode next = cur.next;
        while (n > 1) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
            n--;
        }
        head.next = cur;
        cur.next = pre;
        tail.next = next;
        return tmp.next;
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][m] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char c = t.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                if (c == s.charAt(j)) {
                    dp[j][i] = dp[j + 1][i + 1] + dp[j + 1][i];
                } else {
                    dp[j][i] += dp[j + 1][i];
                }
            }
        }
        return dp[0][0];
    }
}

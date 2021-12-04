package leetcode.contest;

import leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author long
 * @Date 2021/11/14 10:22
 * @Title
 * @Description //TODO
 **/

public class Contest267 {

    public static void main(String[] args) {
        Contest267 contest = new Contest267();
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        contest.reverseEvenLengthGroups(node1);
    }


    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int m = requests.length;
        int[] parent = new int[n];
        boolean[] ans = new boolean[m];
        boolean[][] not = new boolean[n][n];
        for (int[] r : restrictions) {
            not[r[0]][r[1]] = true;
            not[r[1]][r[0]] = true;
        }
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int x = findParent(parent, requests[i][0]);
            int y = findParent(parent, requests[i][1]);
            if (x == y) {
                ans[i] = true;
            } else if (not[x][y] || not[y][x]) {
                ans[i] = false;
            } else {
                parent[x] = y; //合并
                for (int j = 0; j < n; j++) {
                    if (not[x][j]) { //父节点存储了该集合所有的限制
                        not[y][j] = true;
                        not[j][y] = true;
                    }
                }
                ans[i] = true;
            }
        }
        return ans;
    }

    public int findParent(int[] parent, int v) {
        while (parent[v] != v) {
            parent[v] = parent[parent[v]];
            v = parent[v];
        }
        return v;
    }


    public boolean[] friendRequests1(int n, int[][] restrictions, int[][] requests) {
        int m = requests.length;
        boolean[] ans = new boolean[m];
        Set<Integer>[] notSet = new Set[n];
        Set<Integer>[] set = new Set[n];
        for (int i = 0; i < n; i++) {
            notSet[i] = new HashSet<>();
            set[i] = new HashSet<>();
        }
        for (int[] r : restrictions) {
            notSet[r[0]].add(r[1]);
            notSet[r[1]].add(r[0]);
        }
        for (int i = 0; i < m; i++) {
            if (!notSet[requests[i][0]].contains(requests[i][1])) {
                Set<Integer> s = new HashSet<>();
                boolean[] flag = new boolean[n];
                Queue<Integer> queue = new LinkedList<>();
                queue.add(requests[i][0]);
                queue.add(requests[i][1]);
                s.add(requests[i][0]);
                s.add(requests[i][1]);
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    flag[k] = true;
                    for (int next : set[k]) {
                        if (!flag[next]) {
                            queue.add(next);
                        }
                        s.add(next);
                    }
                }
                boolean f = false;
                for (int[] r : restrictions) {
                    if (s.contains(r[0]) && s.contains(r[1])) {
                        f = true;
                        break;
                    }
                }
                if (!f) {
                    ans[i] = true;
                    set[requests[i][0]].add(requests[i][1]);
                    set[requests[i][1]].add(requests[i][0]);
                }
            }
        }
        return ans;
    }

    public String decodeCiphertext(String encodedText, int r) {
        int len = encodedText.length();
        if (len == 0) return "";
        int c = len / r;
        char[][] text = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                text[i][j] = encodedText.charAt(i * c + j);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < c; i++) {
            int j = i;
            int k = 0;
            while (j < c && k < r) {
                builder.append(text[k][j]);
                j++;
                k++;
            }
        }
        while (builder.charAt(builder.length() - 1) == ' ') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }


    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode node = head;
        head = tmpHead;
        int k = 1;
        while (node != null) {
            int i = 0;
            LinkedList<ListNode> list = new LinkedList<>();
            while (node != null && i < k) {
                list.addLast(node);
                node = node.next;
                i++;
            }
            int len = list.size();
            while (!list.isEmpty()) {
                if (len % 2 == 0) {
                    head.next = list.pollLast();
                } else {
                    head.next = list.pollFirst();
                }
                head = head.next;
            }
            k++;
        }
        head.next = null;
        return tmpHead.next;
    }


    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int ans = (tickets[k] - 1) * n + (k + 1);
        for (int i = 0; i < n; i++) {
            if (tickets[i] < tickets[k]) {
                if (i < k) {
                    ans -= tickets[k] - tickets[i];
                } else if (i > k) {
                    ans -= tickets[k] - tickets[i] - 1;
                }
            }
        }
        return ans;
    }
}

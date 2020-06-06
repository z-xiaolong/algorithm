package leetcode.hard;

import leetcode.entity.ListNode;

import java.util.List;

/**
 * @Author long
 * @Date 2020/5/16 8:53
 * @Title 25. K 个一组翻转链表
 * @Description //TODO
 **/

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        reverseKGroup.reverseKGroup(node1, 2);
    }

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) return head;
        ListNode pre = new ListNode(-1);
        ListNode tempPre = pre;
        ListNode cur = head;
        while (isLength(cur, k)) {
            ListNode node = cur;
            cur = reverse(tempPre, cur, k);
            tempPre = node;
        }
        tempPre.next = cur;
        return pre.next;
    }

    public ListNode reverse(ListNode prevNode, ListNode node, int k) {
        ListNode pre = prevNode;
        ListNode cur = node;
        ListNode next = null;
        while (k > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            k--;
        }
        prevNode.next = pre;
        node.next = null;
        return next;
    }

    public boolean isLength(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return k == 0;
    }
}

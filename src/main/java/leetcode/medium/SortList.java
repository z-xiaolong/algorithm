package leetcode.medium;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/4/18 10:26
 * @Title 148. 排序链表
 * @Description //TODO
 **/

public class SortList {


    //别人的解，归并：执行用时 :7 ms, 在所有 Java 提交中击败了34.67%的用户
    public ListNode sortList(ListNode head) {
        int length = getLength(head);
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        int interval = 1;
        while (interval < length) {
            ListNode prev = tempHead;
            ListNode cur = tempHead.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, interval);
                cur = split(right, interval);
                prev = merge(prev, left, right);
            }
            interval <<= 1;
        }
        return tempHead.next;
    }


    public int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public ListNode split(ListNode head, int interval) {
        if (head == null) return null;
        while (interval > 1 && head.next != null) {
            interval--;
            head = head.next;
        }
        ListNode tail = head.next;
        head.next = null;
        return tail;
    }

    public ListNode merge(ListNode head, ListNode node1, ListNode node2) {
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }
        head.next = node1 == null ? node2 : node1;
        while (head.next != null) {
            head = head.next;
        }
        return head;  // 返回尾部节点
    }
}
